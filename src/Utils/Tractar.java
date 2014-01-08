package Utils;

import Model.Alumne;
import Model.CrearXML;
import Model.Llegir;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class Tractar {

    private TreeSet<Alumne> treeAlumne = new TreeSet<Alumne>();

    public TreeSet<String> asignatures(String nomFitxer) {
        Llegir lc = new Llegir();
        ArrayList<String[]> dades = new ArrayList<String[]>();

        TreeSet<String> llistatMateries = new TreeSet<String>();
        try {
            //Mètode de lectura
            if(nomFitxer.endsWith(".csv")){
                dades = lc.llegir(nomFitxer);
            } else{
                throw new Exception("el fitxer no té el format correcte");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "el fitxer no té el format correcte", null, JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        //Creació alumnes amb les dades del fitxer d'entrada (csv)
        for (int i = 0; i < dades.size(); i++) {
            //Per cada iteració creació array matèries i asignatures
            TreeSet<String> materiasAlumne = new TreeSet<String>();
            Alumne alu = new Alumne();
            String[] reg1 = dades.get(i);
            //Tractament de les lines del fitxer d'entrada assignant els valors
            for (int j = 0; j < reg1.length; j++) {
                if (j == 1) {
                    alu.setCognoms(reg1[j]);
                }
                if (j == 2) {
                    alu.setNom(reg1[j]);
                }
                if (j == 3) {
                    alu.setGrup(reg1[j]);
                }
                if (j > 3) {
                    materiasAlumne.add(reg1[j]);
                }
            }
            //Asignació dades a l'objecte alumne 
            alu.setMateria(materiasAlumne);
            //Afegir objecte alumne a la estructura TreeSet de Alumnes
            treeAlumne.add(alu);
            //Afegir les matèries al total de materies
            llistatMateries.addAll(materiasAlumne);
        }
        // 
        return llistatMateries;
    }

    public void desarFitxer(TreeSet<String> materias, String path) {
        CrearXML crear = new CrearXML();
        crear.llistatMateria(materias, this.treeAlumne);
        crear.desarFitxer(path);
    }
}

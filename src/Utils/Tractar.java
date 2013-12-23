package Utils;

import Model.Alumne;
import Model.Llegir;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Tractar {

    	private  TreeSet<Alumne> treeAlumne = new TreeSet<Alumne>();
	
	public  TreeSet<String> asignatures(String nomFitxer) {            
           	Llegir lc = new Llegir();
		ArrayList<String[]> dades = new ArrayList<String[]>();
		
          	TreeSet<String> llistatMateries = new TreeSet<String>();
                //Mètode de lectura 
		dades = lc.llegir(nomFitxer);

		//Creació alumnes amb les dades del fitxer d'entrada (csv)
		for (int i = 0; i < dades.size(); i++) {
			//Per cada iteració creació array matèries i asignatures
                        TreeSet<String> materiasAlumne = new TreeSet<String>();
			Alumne alu = new Alumne();
			String[] reg1 = dades.get(i);
                        //Tractament de les lines del fitxer d'entrada assignant els valors
			for (int j = 0; j < reg1.length; j++) {
				if (j == 1)alu.setCognoms(reg1[j]);
				if (j == 2)alu.setNom(reg1[j]);
				if (j == 3)alu.setGrup(reg1[j]);
				if (j > 3)materiasAlumne.add(reg1[j]);
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

    public TreeSet<Alumne> getTreeAlumne() {
        return treeAlumne;
    }

}

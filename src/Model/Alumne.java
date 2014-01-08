package Model;

import java.util.TreeSet;

public class Alumne implements Comparable<Alumne> {

    private String cognoms, nom, grup;
    private TreeSet<String> materia;

    public Alumne() {
        this.cognoms = "";
        this.nom = "";
        this.grup = "";
        this.materia = null;
    }

    public Alumne(String cognoms, String nom, String grup, TreeSet<String> materia) {
        super();
        this.cognoms = cognoms;
        this.nom = nom;
        this.grup = grup;
        this.materia = materia;
    }

    public TreeSet<String> getMateria() {
        return materia;
    }

    public void setMateria(TreeSet<String> materia) {
        this.materia = materia;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognomsNom) {
        this.cognoms = cognomsNom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGrup() {
        return grup;
    }

    public void setGrup(String grup) {
        this.grup = grup;
    }

    @Override
    public String toString() {
        return "Alumne cognoms=" + cognoms + ", nom=" + nom + ", grup=" + grup
                + ", materia=" + materia + "\n";
    }

    @Override
    public int compareTo(Alumne o) {

        int valor = this.grup.compareToIgnoreCase(o.getGrup());
        return valor == 0 ? this.cognoms.compareToIgnoreCase(o.getCognoms()) : valor;

    }
}

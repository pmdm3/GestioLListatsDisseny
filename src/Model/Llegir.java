package Model;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Llegir {

    public ArrayList<String[]> llegir(String path) {
        File fitxer;
        //Creació buffer per la lectura
        BufferedReader br = null;
        ArrayList<String[]> dades = new ArrayList<String[]>();

        try {
            //Creació fitxer amb el path indicat
            fitxer = new File(path);
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fitxer), Charset.forName("ISO-8859-15")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //Tractament de les lines del fitxer
            String linea = br.readLine();
            while (linea != null) {
                            //Comprovar que les linies no són comentaris
                //En cas afirmatiu eliminar caracters
                //Traspas de la linea a la estructura a tractar (dades)
                if (!linea.startsWith(" #")) {
                    linea = linea.replace("\"", "");
                    dades.add(linea.split(","));
                }
                //Següent linea
                linea = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dades;
    }
}

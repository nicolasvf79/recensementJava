package fr.diginamic.fichier;
import java.io.File;
import java.io.IOException;
import java.util.List;

import fr.epsi.b3.recensement.Recensement;
import fr.epsi.b3.recensement.Ville;
import org.apache.commons.io.FileUtils;

public class LectureFichier {
    public void lire()
    {
        try{
            File file = new File("C:/temp/recensement 2016.csv");
            List<String> lignes = FileUtils.readLines(file, "UTF-8");

            for (String ligne: lignes){
                String[] morceau = ligne.split(";");
                String codeRegion = morceau[0];
                String nomRegion = morceau[1];
                String codeDepartement = morceau[2];
                String codeCommune = morceau[5];
                String nomCommune = morceau[6];
                String population = morceau[7];

                if (isNumeric(population) == true)
                {
                    int populationTotale = Integer.parseInt(population.replace(" ", "").trim());

                    Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale);
                    Recensement recensement = new Recensement();
                    recensement.getVilles().add(ville);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static boolean isNumeric(String string) {
        int intValue;

        //System.out.println(String.format("Parsing string: \"%s\"", string));

        if(string == null || string.equals("")) {
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            //System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
}

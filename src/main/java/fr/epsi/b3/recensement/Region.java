// RECHERCHE 10 RÉGIONS LES PLUS PEUPLÉES
package fr.epsi.b3.recensement;

import java.util.*;

public class Region {
    public void Top10Region(Recensement recensement)
    {
        HashMap<String, Integer> compteurs = new HashMap<>();

        for (int i = 0; i < recensement.getVilles().size(); i++)
        {
            Ville ville = recensement.getVilles().get(i);
            String region = ville.getNomRegion();

            Integer compteur = compteurs.get(region);

            if (compteur == null) {
                compteur = 0;
            }

            compteur++;

            compteurs.put(region, compteur);
        }

        Set<String> regions = compteurs.keySet();
        Iterator<String> iterateur = regions.iterator();

        int index = 0;
        String[][] regionArray = new String[compteurs.size()][2];

        while (iterateur.hasNext()) {
            String region = iterateur.next();

            int population = 0;
            for (int i = 0; i < recensement.getVilles().size(); i++)
            {
                if ((recensement.getVilles().get(i).getNomRegion()).equals(region) == true)
                {
                    population += recensement.getVilles().get(i).getPopulationTotale();
                }
            }
            //System.out.println("Région : " + region + " / Nb habitants : " + population);

            regionArray[index][0] = region;
            regionArray[index][1] = String.valueOf(population);
            index++;
        }

        sortArrayByScore(regionArray);

        for(int i = 0; i < 10; i++) {
            System.out.print(i+1 + ". ");
            for (int j = 0; j < regionArray[i].length; j++)
                System.out.print(regionArray[i][j] + " ");
            System.out.println();
        }
    }

    public static void sortArrayByScore(String[][] array) {
        String tmpName, tmpScore;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0 ; i < array.length - 1 ; i++) {
                if (Integer.parseInt(array[i][1]) < Integer.parseInt(array[i+1][1])){
                    sorted = false;
                    // SWAP NAMES
                    tmpName = array[i][0];
                    array[i][0] = array[i+1][0];
                    array[i+1][0] = tmpName;

                    // SWAP SCORES
                    tmpScore = array[i][1];
                    array[i][1] = array[i+1][1];
                    array[i+1][1] = tmpScore;
                }
            }
        }
    }
}

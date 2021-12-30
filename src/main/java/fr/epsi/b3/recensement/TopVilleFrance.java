package fr.epsi.b3.recensement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TopVilleFrance {
    public void Top10Ville(Recensement recensement)
    {
        HashMap<String, Integer> compteurs = new HashMap<>();

        for (int i = 0; i < recensement.getVilles().size(); i++)
        {
            Ville ville = recensement.getVilles().get(i);
            String city = ville.getNomCommune();

            Integer compteur = compteurs.get(city);

            if (compteur == null) {
                compteur = 0;
            }

            compteur++;

            compteurs.put(city, compteur);
        }

        Set<String> cities = compteurs.keySet();
        Iterator<String> iterateur = cities.iterator();

        int index = 0;
        String[][] cityArray = new String[compteurs.size()][2];

        while (iterateur.hasNext()) {
            String city = iterateur.next();

            int population = 0;
            for (int i = 0; i < recensement.getVilles().size(); i++)
            {
                if ((recensement.getVilles().get(i).getNomCommune()).equals(city) == true)
                {
                    population += recensement.getVilles().get(i).getPopulationTotale();
                }
            }

            cityArray[index][0] = city;
            cityArray[index][1] = String.valueOf(population);
            index++;
        }

        sortArrayByScore(cityArray);

        for(int i = 0; i < 10; i++) {
            System.out.print(i+1 + ". ");
            for (int j = 0; j < cityArray[i].length; j++)
                System.out.print(cityArray[i][j] + " ");
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

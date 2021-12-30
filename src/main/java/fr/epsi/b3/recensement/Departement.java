// RECHERCHE 10 DÉPARTEMENT LES PLUS PEUPLÉS
package fr.epsi.b3.recensement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Departement {
    public void Top10Departement(Recensement recensement)
    {
        HashMap<String, Integer> compteurs = new HashMap<>();

        for (int i = 0; i < recensement.getVilles().size(); i++)
        {
            Ville ville = recensement.getVilles().get(i);
            String departement = ville.getCodeDepartement();

            Integer compteur = compteurs.get(departement);

            if (compteur == null) {
                compteur = 0;
            }

            compteur++;

            compteurs.put(departement, compteur);
        }

        Set<String> departements = compteurs.keySet();
        Iterator<String> iterateur = departements.iterator();

        int index = 0;
        String[][] departementArray = new String[compteurs.size()][2];

        while (iterateur.hasNext()) {
            String departement = iterateur.next();

            int population = 0;
            for (int i = 0; i < recensement.getVilles().size(); i++)
            {
                if ((recensement.getVilles().get(i).getCodeDepartement()).equals(departement) == true)
                {
                    population += recensement.getVilles().get(i).getPopulationTotale();
                }
            }

            departementArray[index][0] = departement;
            departementArray[index][1] = String.valueOf(population);
            index++;
        }

        sortArrayByScore(departementArray);

        for(int i = 0; i < 10; i++) {
            System.out.print(i+1 + ". ");
            for (int j = 0; j < departementArray[i].length; j++)
                System.out.print(departementArray[i][j] + " ");
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

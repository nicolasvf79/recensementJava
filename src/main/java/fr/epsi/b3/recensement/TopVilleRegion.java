package fr.epsi.b3.recensement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopVilleRegion {
    public void TopVilleRegion(Recensement recensement, Scanner scanner)
    {
        String region = scanner.nextLine();
        List<String> listVille = new ArrayList<>();
        List<String> listHabitant = new ArrayList<>();

        for (int i = 0; i < recensement.getVilles().size(); i++)
        {
            if ((recensement.getVilles().get(i).getNomRegion()).equals(region) == true)
            {
                listVille.add(recensement.getVilles().get(i).getNomCommune());
                listHabitant.add(String.valueOf(recensement.getVilles().get(i).getPopulationTotale()));
            }
        }

        String[][] citiesArray = new String[listVille.size()][2];
        for (int y = 0; y < listVille.size(); y++)
        {
            citiesArray[y][0] = listVille.get(y);
            citiesArray[y][1] = listHabitant.get(y);
        }

        sortArrayByScore(citiesArray);

        for(int i = 0; i < 10; i++) {
            System.out.print(i+1 + ". ");
            for (int j = 0; j < citiesArray[i].length; j++)
                System.out.print(citiesArray[i][j] + " ");
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

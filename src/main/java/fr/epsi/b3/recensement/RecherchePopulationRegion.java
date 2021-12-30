package fr.epsi.b3.recensement;

import java.util.Scanner;

public class RecherchePopulationRegion {
    public void traiter(Recensement recensement, Scanner scanner){
        String region = scanner.nextLine();
        int population = 0;

        for (int i = 0; i < recensement.getVilles().size(); i++)
        {
            if ((recensement.getVilles().get(i).getNomRegion()).equals(region) == true)
            {
                population += recensement.getVilles().get(i).getPopulationTotale();
            }
        }

        System.out.println("Département = " + region + " / population = " + population);
    }
}

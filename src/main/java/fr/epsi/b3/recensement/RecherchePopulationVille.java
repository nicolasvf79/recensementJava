package fr.epsi.b3.recensement;

import java.util.Scanner;

public class RecherchePopulationVille extends MenuService{
    public void traiter(Recensement recensement, Scanner scanner){
        String ville = scanner.nextLine();

        int i = 0;
        while ((recensement.getVilles().get(i).getNomCommune()).equals(ville) == false)
        {
            i++;
        }
        System.out.println("Ville = " + ville + " / population = " + recensement.getVilles().get(i).getPopulationTotale());
    }
}

package fr.epsi.b3.recensement;
import java.util.Scanner;

public class RecherchePopulationDepartement extends MenuService {
    public void traiter(Recensement recensement, Scanner scanner){
        String departement = scanner.nextLine();
        int population = 0;
        for (int i = 0; i < recensement.getVilles().size(); i++)
        {
            if ((recensement.getVilles().get(i).getCodeDepartement()).equals(departement) == true)
            {
                population += recensement.getVilles().get(i).getPopulationTotale();
            }
        }

        System.out.println("Département = " + departement + " / population = " + population);
    }
}

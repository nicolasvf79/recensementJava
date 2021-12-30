package fr.epsi.b3.recensement;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Application {
    public static void main(String[] args)
    {
        Recensement recensement = new Recensement();

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
                //System.out.println("Ville = " + nomCommune);

                try{
                    int populationTotale = Integer.parseInt(population.replace(" ", "").trim());

                    Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale);
                    recensement.getVilles().add(ville);
                } catch (Exception e)
                {
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }



        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Population d'une ville donnée");
        System.out.println("2. Population d'un département donné");
        System.out.println("3. Population d'une région donnée");
        System.out.println("4. Afficher les 10 régions les plus peuplées");
        System.out.println("5. Afficher les 10 département les plus peuplés");
        System.out.println("6. Afficher les 10 villes les plus peuplées d'un département");
        System.out.println("7. Afficher les 10 villes les plus peuplées d'une région");
        System.out.println("8. Afficher les 10 villes les plus peuplée de France");
        System.out.println("9. Sortir");
        System.out.print("Choix du menu : ");
        int str = scanner.nextInt();
        int choix = str;



        switch (choix){
            case 1:
                Scanner popVille = new Scanner(System.in);
                System.out.print("Choix de la ville : ");
                RecherchePopulationVille rechercheVille = new RecherchePopulationVille();
                rechercheVille.traiter(recensement,popVille);
                break;
            case 2:
                Scanner popDepartement = new Scanner(System.in);
                System.out.print("Choix du département : ");
                RecherchePopulationDepartement rechercheDepartement = new RecherchePopulationDepartement();
                rechercheDepartement.traiter(recensement, popDepartement);
                break;
            case 3:
                Scanner popRegion = new Scanner(System.in);
                System.out.print("Choix de la région : ");
                RecherchePopulationRegion rechercherRegion = new RecherchePopulationRegion();
                rechercherRegion.traiter(recensement, popRegion);
                break;
            case 4:
                Region region = new Region();
                region.Top10Region(recensement);
                break;
            case 5:
                Departement departement = new Departement();
                departement.Top10Departement(recensement);
                break;
            case 6:
                Scanner topVilleDepartementSC = new Scanner(System.in);
                System.out.print("Choix du département : ");
                TopVilleDepartement topVilleDepartement = new TopVilleDepartement();
                topVilleDepartement.TopVilleDepartement(recensement, topVilleDepartementSC);
                break;
            case 7:
                Scanner topVilleRegionSC = new Scanner(System.in);
                System.out.print("Choix de la région : ");
                TopVilleRegion topVilleRegion = new TopVilleRegion();
                topVilleRegion.TopVilleRegion(recensement, topVilleRegionSC);
                break;
            case 8:
                TopVilleFrance villeFrance = new TopVilleFrance();
                villeFrance.Top10Ville(recensement);
                break;
            case 9:
                break;
        }
    }
}

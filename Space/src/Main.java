

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {

        Simulation simulation = new Simulation();

        File phase1 = new File("C:\\Downloads\\phase-1.txt");
        File phase2 = new File("C:\\Downloads\\phase-2.txt");
        int totalCost = 0;
        ArrayList listOfItems = new ArrayList();
        ArrayList listOfRockets = new ArrayList();


        System.out.println("Initiating Phase 1");
        listOfItems = new ArrayList();
        listOfItems = simulation.loadItems(phase1);

         listOfRockets = new ArrayList();
        listOfRockets = simulation.loadU1(listOfItems);

        totalCost = simulation.runSimulation(listOfRockets);
        System.out.println("Total cost simulation Phase 1, launching "+listOfRockets.size()+" U1 rockets: $" + totalCost + " millions.");



        System.out.println("Initiating Phase 2");
         listOfItems = new ArrayList();
        listOfItems = simulation.loadItems(phase2);

         listOfRockets = new ArrayList();
        listOfRockets = simulation.loadU1(listOfItems);

        totalCost = simulation.runSimulation(listOfRockets);
        System.out.println("Total cost simulation Phase 2, launching "+listOfRockets.size()+" U1 rockets: $" + totalCost + " millions.");




        System.out.println("Initiating Phase 1");
        listOfItems = new ArrayList();
        listOfItems = simulation.loadItems(phase1);

        listOfRockets = new ArrayList();
        listOfRockets = simulation.loadU2(listOfItems);

        totalCost = simulation.runSimulation(listOfRockets);
        System.out.println("Total cost simulation Phase 1, launching "+listOfRockets.size()+" U2 rockets: $" + totalCost + " millions.");



        System.out.println("Initiating Phase 2");
        listOfItems = new ArrayList();
        listOfItems = simulation.loadItems(phase2);

        listOfRockets = new ArrayList();
        listOfRockets = simulation.loadU2(listOfItems);

        totalCost = simulation.runSimulation(listOfRockets);
        System.out.println("Total cost simulation Phase 2, launching "+listOfRockets.size()+" U2 rockets: $" + totalCost + " millions.");



    }
}
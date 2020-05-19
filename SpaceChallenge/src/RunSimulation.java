import java.io.File;
import java.util.ArrayList;


public class RunSimulation {

	public static void main(String[] args) throws Exception {
			
		int totalBudgetU1, totalBudgetU2, budgetU1Ph1, budgetU2Ph1, budgetU1Ph2, budgetU2Ph2;
		
		Simulation simulation = new Simulation();

		// load rocket cargo item manifests
        File phase1 = new File("C:\\Downloads\\phase-1.txt");
        File phase2 = new File("C:\\Downloads\\phase-2.txt");
        
        ArrayList<Item> loadItemList = new ArrayList<Item>();
        ArrayList<Rocket> rocketsLoaded = new ArrayList<Rocket>();

        
        loadItemList = simulation.loadItems(phase1); 
        rocketsLoaded = simulation.loadU1(loadItemList);
        budgetU1Ph1 = simulation.runSimulation(rocketsLoaded);
        
        
        loadItemList = simulation.loadItems(phase2); 
        rocketsLoaded = simulation.loadU1(loadItemList);
        budgetU1Ph2 = simulation.runSimulation(rocketsLoaded);
        
        totalBudgetU1 = budgetU1Ph1 + budgetU1Ph2;
        System.out.println("Total cost simulation of U1: $" + totalBudgetU1 + " millions.");
        
        
        loadItemList = simulation.loadItems(phase1); 
        rocketsLoaded = simulation.loadU2(loadItemList);
        budgetU2Ph1 = simulation.runSimulation(rocketsLoaded);   
        
        loadItemList = simulation.loadItems(phase2); 
        rocketsLoaded = simulation.loadU2(loadItemList);
        budgetU2Ph2 = simulation.runSimulation(rocketsLoaded);

        totalBudgetU2 = budgetU2Ph1 + budgetU2Ph2;
        System.out.println("Total cost simulation of U2: $" + totalBudgetU2 + " millions.");
        
	}

}

import java.io.File;
import java.util.ArrayList;

/**
* Create a Main class (RunSimulation) with the main method and start running the simulation:
* Create a Simulation object
* Load Items for Phase-1 and Phase-2
* Load a fleet of U1 rockets for Phase-1 and then for Phase-2
* Run the simulation using the fleet of U1 rockets and display the total budget required.
* Repeat the same for U2 rockets and display the total budget for that.
*/

public class RunSimulation {

	public static void main(String[] args) throws Exception {
			
		int totalBudgetU1, totalBudgetU2, budgetU1Ph1, budgetU2Ph1, budgetU1Ph2, budgetU2Ph2;
		
		Simulation simulation = new Simulation();

		// load rocket cargo item manifests
        File phase1 = new File("C:\\Downloads\\phase-1.txt");
        File phase2 = new File("C:\\Downloads\\phase-2.txt");
        
        ArrayList<Item> loadItemList = new ArrayList<Item>();
        ArrayList<U1> rocketsU1Loaded = new ArrayList<>();
        ArrayList<U2> rocketsU2Loaded = new ArrayList<>();

        
        loadItemList = simulation.loadItems(phase1); 
        rocketsU1Loaded = (ArrayList<U1>) simulation.loadU1(loadItemList);
        budgetU1Ph1 = simulation.runU1Simulation(rocketsU1Loaded);
        System.out.println("U1 Phase1: Rockets required to carry items "+rocketsU1Loaded.size()+" at a cost including any destroyed: $"+budgetU1Ph1);
        
        
        loadItemList = simulation.loadItems(phase2); 
        rocketsU1Loaded = (ArrayList<U1>) simulation.loadU1(loadItemList);
        budgetU1Ph2 = simulation.runU1Simulation(rocketsU1Loaded);
        System.out.println("U1 Phase2: Rockets required to carry items "+rocketsU1Loaded.size()+" at a cost including any destroyed: $"+budgetU1Ph2);
        
        totalBudgetU1 = budgetU1Ph1 + budgetU1Ph2;
        System.out.println("Total cost simulation of U1: $" + totalBudgetU1 + " millions.");
        
        
        loadItemList = simulation.loadItems(phase1); 
        rocketsU2Loaded = (ArrayList<U2>) simulation.loadU2(loadItemList);
        budgetU2Ph1 = simulation.runU2Simulation(rocketsU2Loaded);   
        System.out.println("U2 Phase1: Rockets required to carry items "+rocketsU2Loaded.size()+" at a cost including any destroyed: $"+budgetU2Ph1);
        
        loadItemList = simulation.loadItems(phase2); 
        rocketsU2Loaded = (ArrayList<U2>) simulation.loadU2(loadItemList);
        budgetU2Ph2 = simulation.runU2Simulation(rocketsU2Loaded);
        System.out.println("U2 Phase2: Rockets required to carry items "+rocketsU2Loaded.size()+" at a cost including any destroyed: $"+budgetU2Ph2);
        
        totalBudgetU2 = budgetU2Ph1 + budgetU2Ph2;
        System.out.println("Total cost simulation of U2: $" + totalBudgetU2 + " millions.");
        
	}

}

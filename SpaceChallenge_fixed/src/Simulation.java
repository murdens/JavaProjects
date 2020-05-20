import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
	
	  /**
     * loadItems: this method loads all items from a text file and returns an ArrayList of Items
     * loadItems should read the text file line by line and create an Item object for each
     * then add it to an ArrayList of Items. The method should then return that ArrayList.
     * @param textFile
     * @return listOfItems
     * @throws Exception
     */
	
	
	public  ArrayList<Item> loadItems(File textFile) throws Exception{
        ArrayList<Item> loadItemList = new ArrayList<Item>();
        Scanner fileScanner = new Scanner(textFile);

        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            String [] listItem = line.split("=");
            Item item = new Item();
            item.name = listItem[0];
            item.weight = Integer.parseInt(listItem[1])/1000; // convert kgs to tonnes
            loadItemList.add(item);
        }
        System.out.println("File read in items: "+ loadItemList.size());
        return loadItemList;
    }

    /**
     * loadU1: this method takes the ArrayList of Items returned from loadItems
     * and starts creating U1 rockets. It first tries to fill up 1 rocket with as many items as possible
     * before creating a new rocket object and filling that one until all items are loaded.
     * The method then returns the ArrayList of those U1 rockets that are fully loaded.
     * @param listOfItems
     * @return
     */
    
    public ArrayList<U1> loadU1(ArrayList<Item> loadItemList){
    	
    	// create ArrayLists to hold number of rockets/weight and track items loaded.
    	ArrayList<U1> rocketsLoaded = new ArrayList<>();
        
    	U1 rocketU1 = new U1();
    	System.out.println("Items to load in U1 sim: " + loadItemList.size());
        // initialise variables.
        int numberOfRockets = 1;
        int itemCount = 0;
          
        System.out.println("Loading U1s....");
        
        for (Item i : loadItemList){
        	
        	while(!rocketU1.canCarry(i)) {
        		rocketsLoaded.add(rocketU1);
        		rocketU1 = new U1();
        		numberOfRockets++;
        	}
        		rocketU1.carry(i);
      			itemCount++;
      			
        }
		rocketsLoaded.add(rocketU1);
		System.out.println("Loaded items U1 sim: "+itemCount);
		System.out.println("Rocket count U1 sim: "+ numberOfRockets);
        return rocketsLoaded;
    }		
     
           

         
    
    /**
     * loadU2: this method takes the ArrayList of Items returned from loadItems
     * and starts creating U1 rockets. It first tries to fill up 1 rocket with as many items as possible
     * before creating a new rocket object and filling that one until all items are loaded.
     * The method then returns the ArrayList of those U1 rockets that are fully loaded.
     * @param listOfItems
     * @return
     */
    

    public ArrayList<U2> loadU2(ArrayList<Item> loadItemList){
       	
     	// create ArrayLists to hold number of rockets/weight and track items loaded.
       	ArrayList<U2> rocketsLoaded = new ArrayList<>();
        
    	U2 rocketU2 = new U2();
    	System.out.println("Items to load in U2 sim: " + loadItemList.size());
        // initialise variables.
        int numberOfRockets = 1;
        int itemCount = 0;
          
        System.out.println("Loading U2s....");
        
        for (Item i : loadItemList){
        	
        	while(!rocketU2.canCarry(i)) {
        		rocketsLoaded.add(rocketU2);
        		rocketU2 = new U2();
        		numberOfRockets++;
        	}
        		rocketU2.carry(i);
      			itemCount++;
        }
		rocketsLoaded.add(rocketU2);
		System.out.println("Loaded items U2 sim: "+itemCount);
		System.out.println("Rocket count U2 sim: "+ numberOfRockets);
        return rocketsLoaded;
    }		
             
    /**
     * runSimulation: this method takes an ArrayList of Rockets and calls launch
     * and land methods for each of the rockets in the ArrayList. Every time a rocket 
     * explodes or crashes (i.e if launch or land return false) it will have to send 
     * that rocket again. All while keeping track of the total budget required to 
     * send each rocket safely to Mars. runSimulation then returns the total budget 
     * required to send all rockets (including the crashed ones).
     * @return 
     */
    
    public int runU1Simulation(ArrayList<U1> rocketsLoaded) {
    	int totalBudget = 0;
    	
    	for (int i=0;i < rocketsLoaded.size();i++) {
    		Rocket rocket = rocketsLoaded.get(i);
    		while (!rocket.launch() || !rocket.land()) {
    			totalBudget += rocket.rocketCost;
    		}
    		totalBudget += rocket.rocketCost;
    	}	
    return totalBudget;
    }

public int runU2Simulation(ArrayList<U2> rocketsLoaded) {
	int totalBudget = 0;
	
	for (int i=0;i < rocketsLoaded.size();i++) {
		Rocket rocket = rocketsLoaded.get(i);
		while (!rocket.launch() || !rocket.land()) {
			totalBudget += rocket.rocketCost;
		}
		totalBudget += rocket.rocketCost;
	}	
return totalBudget;
}
}

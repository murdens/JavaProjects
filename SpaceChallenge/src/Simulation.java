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
        System.out.println(loadItemList.size());
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
    
    public ArrayList<Rocket> loadU1(ArrayList<Item> loadItemList){
    	
    	// create ArrayLists to hold number of rockets/weight and track items loaded.
    	ArrayList<Rocket> rocketsLoaded = new ArrayList<Rocket>();
        
        // initialise variables.
        int totalWeight = 0;
        int numberOfRockets = 0;
        
     // create rocketU1 object.
        U1 rocketU1 = new U1();
        rocketU1.currentWeight += rocketU1.rocketWeight;
        System.out.println("Loading U1....");
        
        for (int i=0; i<loadItemList.size(); i++){
        	  
            Item eachItem = loadItemList.get(i);
            	if(rocketU1.canCarry(eachItem)) {
            		 rocketU1.carry(eachItem);
            	} else {
            	    rocketsLoaded.add(rocketU1);
            	    numberOfRockets++;
            	    System.out.println("Rocket count: "+ numberOfRockets);
            	} 
            
        }
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
    

    public ArrayList<Rocket> loadU2(ArrayList<Item> loadItemList){
       	
     	// create ArrayLists to hold number of rockets/weight and track items loaded.
       	ArrayList<Rocket> rocketsLoaded = new ArrayList<Rocket>();
             
        // initialise variables.
        int totalWeight = 0;
        int numberOfRockets = 0;
             
        // create rocketU1 object.
        U2 rocketU2 = new U2();
        rocketU2.currentWeight += rocketU2.rocketWeight;
        System.out.println("Loading U2....");
             
        for (int i=0; i<loadItemList.size(); i++){
             	  
        	Item eachItem = loadItemList.get(i);	
        	if(rocketU2.canCarry(eachItem)) {
        	rocketU2.carry(eachItem);
            } else {
            rocketsLoaded.add(rocketU2);
            numberOfRockets++;
            System.out.println("Rocket count: "+ numberOfRockets);
            } 
                 
        }
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
    
    public int runSimulation(ArrayList<Rocket> rocketsLoaded) {
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

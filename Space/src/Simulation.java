
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
        System.out.println("loading items...");
        ArrayList listOfItems = new ArrayList();
        Scanner fileScanner = new Scanner(textFile);

        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            String [] scanItems = line.split("=");
            Item item = new Item();
            item.itemName = scanItems[0];
            item.itemWeight = Integer.parseInt(scanItems[1]);
           // System.out.println("loading item named " +item.itemName+", weight: "+ item.itemWeight);
            listOfItems.add(item);
        }
        return listOfItems;
    }


    /**
     * loadU1: this method takes the ArrayList of Items returned from loadItems
     * and starts creating U1 rockets. It first tries to fill up 1 rocket with as many items as possible
     * before creating a new rocket object and filling that one until all items are loaded.
     * The method then returns the ArrayList of those U1 rockets that are fully loaded.
     * @param listOfItems
     * @return
     */
    public ArrayList loadU1(ArrayList<Item> listOfItems){
        //System.out.println("loading U1 Rockets");

        ArrayList listOfRockets = new ArrayList<>();
        int numberOfItems = listOfItems.size();
        System.out.println(("Number of items on the list: "+numberOfItems));

        U1 myRocket = new U1();
        int totalWeight = myRocket.rocketWeight;
        int numberOfRockets = 0;
        myRocket.currentWeight+= myRocket.rocketWeight;
        System.out.println("creating new U1 Rocket, initial weight= "+ totalWeight);

        for (int i=0; i<numberOfItems; i++){
            // while(!listOfItems.isEmpty()){
            //for (Item oneItem: listOfItems){
                  Item oneItem = listOfItems.get(i);
                  //System.out.println("List of items size: "+listOfItems.size());
                  System.out.println("Item n. "+i);
                   if (myRocket.canCarry(oneItem)){
                       System.out.println("loading U1: "+ oneItem.itemWeight);
                       myRocket.carry(oneItem);
                       System.out.println("Current weight= "+myRocket.currentWeight);
                        // int indexItem = listOfItems.indexOf(oneItem);
                       //   listOfItems.remove(indexItem);
                       } else {
                          listOfRockets.add(myRocket);
                          numberOfRockets++;
                          System.out.println("Loaded rocket n. "+numberOfRockets);
                          myRocket = new U1();
                          totalWeight = myRocket.rocketWeight;
                       }
        }
      //  System.out.println("number of rocket U1 fully loaded: "+ numberOfRockets);
        System.out.println("number of rocket U1 fully loaded: "+ listOfRockets.size());
        System.out.println("List of items is empty.");
        return listOfRockets;
    }

    /**
     * loadU2: this method takes the ArrayList of Items returned from loadItems
     * and starts to fill U2 rockets until all items are loaded.
     * The method then returns the ArrayList of those U2 rockets that are fully loaded.
     *
     * @param listOfItems
     * @return
     */
    public ArrayList loadU2(ArrayList<Item> listOfItems){
        System.out.println("loading U2 Rockets");

        ArrayList listOfRockets = new ArrayList<>();
        int numberOfItems = listOfItems.size();
        System.out.println(("Number of items on the list: "+numberOfItems));

        U2 myRocket = new U2();
        int totalWeight = myRocket.rocketWeight;
        int numberOfRockets = 0;
        myRocket.currentWeight+= myRocket.rocketWeight;
        System.out.println("creating new U2 Rocket, initial weight= "+ totalWeight);

        for (int i=0; i<numberOfItems; i++){
            // while(!listOfItems.isEmpty()){
            //for (Item oneItem: listOfItems){
            Item oneItem = listOfItems.get(i);
            System.out.println("Item n. "+i);
            if (myRocket.canCarry(oneItem)){
                System.out.println("loading U2: "+ oneItem.itemWeight);
                myRocket.carry(oneItem);
                System.out.println("Current weight= "+myRocket.currentWeight);
                // int indexItem = listOfItems.indexOf(oneItem);
                //   listOfItems.remove(indexItem);
            } else {
                listOfRockets.add(myRocket);
                numberOfRockets++;
                System.out.println("Loaded rocket n. "+numberOfRockets);
                myRocket = new U2();
                totalWeight = myRocket.rocketWeight;
             }
        }
        //  System.out.println("number of rocket U2 fully loaded: "+ numberOfRockets);
        System.out.println("number of rocket U2 fully loaded: "+ listOfRockets.size());
        System.out.println("List of items is empty.");
        return listOfRockets;
    }


    /**
     * runSimulation: this method takes an ArrayList of Rockets and calls launch and land methods
     * for each of the rockets in the ArrayList. Every time a rocket explodes or crashes
     * (i.e if launch or land return false) it will have to send that rocket again.
     * All while keeping track of the total budget required to send each rocket safely to Mars.
     * runSimulation then returns the total budget required to send all rockets (including the crashed ones).
     * @param listOfRockets
     * @return
     */
    public static int runSimulation(ArrayList<Rocket> listOfRockets){
        int budget = 0;


         //for (Rocket rocket : listOfRockets) {
        for (int i=0; i<listOfRockets.size(); i++){
            Rocket myRocket = new Rocket();
            myRocket = listOfRockets.get(i);
            System.out.println("Run simulation, launching rocket n."+i);
            budget += myRocket.rocketCost;
             if (!myRocket.launch() ||  !myRocket.land()) {
                 budget += myRocket.rocketCost;
                 System.out.println("Launching or landing failed.");
             }
            System.out.println("Launching and landing succeeded.");

        }

        return budget;
    }

}
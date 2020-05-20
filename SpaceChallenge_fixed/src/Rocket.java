

/**
* Class Rocket that implements the SpaceShip Interface.
* launch and land methods in the Rocket class should always return true. 
* When U1 and U2 classes extend the Rocket class they will override these methods to return true or false 
* based on the actual probability of each type.
* carry and canCarry should be implemented here and will not need to be overridden in the U1 and U2 classes
*/

public class Rocket implements SpaceShip {
	 	
	int rocketCost; 
	int rocketWeight; 
	int rocketMaxWeight;
	int currentWeight;
	int cargoCarried;
	int cargoLimit;
	double launchExplode;
	double landCrash;
	

	Rocket() {
		
		cargoCarried =0;
		cargoLimit=0;
		currentWeight = 0;
		launchExplode = 0.0;
		landCrash = 0.0;
    }
	 
	public boolean launch() {
		return true;
	}

	
	public boolean land() {
		return true;
	}

	@Override
	public boolean canCarry(Item item) {
		return(this.currentWeight + item.weight) <= this.rocketMaxWeight;
			 //System.out.println("Yes");
		
	}

	@Override
	public void carry(Item item) {		
		this.currentWeight = this.currentWeight += item.weight;
		  //System.out.println("Loaded weight: "+this.currentWeight);
		this.cargoCarried = this.currentWeight - this.rocketWeight;
		
	}
}

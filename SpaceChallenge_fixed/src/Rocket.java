
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
		
		//rocketCost = 0;
		//rocketWeight = 0;
		//rocketMaxWeight=0;
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

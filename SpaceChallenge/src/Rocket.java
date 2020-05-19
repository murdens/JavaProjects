
public class Rocket implements SpaceShip {
	 	
	int rocketCost; 
	int rocketWeight; 
	int rocketMaxWeight;
	int currentWeight;
	double launchExplode;
	double landCrash;
	

	public boolean launch() {
		return true;
	}

	
	public boolean land() {
		return true;
	}

	@Override
	public boolean canCarry(Item item) {
		
		if((this.currentWeight + item.weight) <= this.rocketMaxWeight) {
			 //System.out.println("Yes");
			return true;
		
		}
		return false;
	}

	@Override
	public int carry(Item item) {		
		this.currentWeight += item.weight;
		  //System.out.println("Loaded weight: "+this.currentWeight);
		return currentWeight;
	}
}

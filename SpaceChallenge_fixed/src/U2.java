import java.util.Random;

/**
 * Create classes U2 that extend the Rocket class and override the land and launch methods to
 * calculate the corresponding chance of exploding and return either true or false based on
 * a random number using the probability equation.
 *
 * U2
 * Rocket cost = $120 Million
 * Rocket weight = 18 Tonnes
 * Max weight (with cargo) = 29 Tonnes
 * Chance of launch explosion = 4% * (cargo carried / cargo limit)
 * Chance of landing crash = 8% * (cargo carried / cargo limit)
 */

public class U2 extends Rocket {
	
	U2() {
		rocketCost = 120;
	    rocketWeight = 18; //tonnes
	    rocketMaxWeight = 29; //tonnes
	    launchExplode = 0.04;
	    landCrash = 0.08;
	    cargoLimit = rocketMaxWeight - rocketWeight;
	    currentWeight = rocketWeight;
		
		}
		 
	
		public boolean launch() {
			double launched = launchExplode* ((double)cargoCarried / (double)cargoLimit);
		//	System.out.println("Chance of explosion: "+ launched);
			if (new Random().nextDouble()  <= launched ) {
				//System.out.println("U2 Rocket Exploded");
				return false;
			}
			//System.out.println("U2 Rocket launched");
			return true;
		
	}
	
		public boolean land() {
			double landed =  landCrash*((double)cargoCarried / (double)cargoLimit);
		//	System.out.println("Chance of crash: "+ landed);
			if (new Random().nextDouble() <= landed) {
				//System.out.println("U2 Rocket crashed");
				return false;
			}
			//System.out.println("U2 Rocket touchdown");
				return true;
			
			}
}
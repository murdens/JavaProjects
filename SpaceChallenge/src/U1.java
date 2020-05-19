import java.util.Random;

/**
 * Create classes U1 that extend the Rocket class and override the land and launch methods to
 * calculate the corresponding chance of exploding and return either true or false based on
 * a random number using the probability equation.
 *
 * U1
 * Rocket cost = $100 Million
 * Rocket weight = 10 Tonnes
 * Max weight (with cargo) = 18 Tonnes
 * Chance of launch explosion = 5% * (cargo carried / cargo limit)
 * Chance of landing crash = 1% * (cargo carried / cargo limit)
 */


public class U1 extends Rocket {
	
		
	public U1() {
	rocketCost = 100;
    rocketWeight = 10; //tonnes
    rocketMaxWeight = 18; //tonnes
    launchExplode = 0.05;
    landCrash = 0.01;
    
    
    
	}
	
		public boolean launch() {
			double launched = launchExplode* (double)((currentWeight - rocketWeight) / (rocketMaxWeight - rocketWeight));
			double result = (double) ((currentWeight - rocketWeight) / (rocketMaxWeight - rocketWeight));
			double current = currentWeight;
			
			System.out.println("Chance of explosion: "+ launched);
			System.out.println("Check: "+ result);
			System.out.println("Check weight: "+ current);
			if (new Random().nextDouble()  <= launched ) {
				//System.out.println("U1 Rocket Exploded");
				return false;
			}
			//System.out.println("U1 Rocket launched");
			return true;
		}
	
		public boolean land() {
			double landed =  landCrash* (double) ((currentWeight - rocketWeight) / (rocketMaxWeight - rocketWeight));
			System.out.println("Chance of crash: "+ landed);
			if (new Random().nextDouble() <= landed) {
				//System.out.println("U1 Rocket crashed");
				return false;
			}
			//System.out.println("U1 Rocket touchdown");
			return true;
		}
}
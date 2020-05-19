
 public class U2 extends Rocket{

    U2() {
        rocketCost = 120; // millions
        rocketWeight = 1800; // tonnes
        rocketMaxWeight = 2900;  // tonnes
        indexLaunchExplosion = 4; //4% *( cargo carried / cargo limit)
        indexLandCrash = 8; //8%*(cargo carried / cargo limit)
    }

    public boolean launch() {
        double randomN = (Math.random()*100);
        //System.out.println("random number: "+ randomN); //random number 0-99
        double succeed=  indexLaunchExplosion* (double) currentWeight/rocketMaxWeight;
        System.out.println("Probability of launch succeeding=" + succeed);
        if (succeed <= randomN) {
            System.out.println("Launch succeeded.");
            return true;
        } else {
            System.out.println("Rocket exploded when launching.");
            return false;
        }
    }

    public boolean land() {
        double randomN = (Math.random()*100);
        //System.out.println("random number: "+ randomN); //random number 0-99
        double succeed=  indexLandCrash* (double) currentWeight/rocketMaxWeight;
        System.out.println("Probability of launch succeeding=" + succeed);
        if (succeed <= randomN) {
            System.out.println("Landed successfully.");
            return true;
        } else {
            System.out.println("Rocket crashed when landing.");
            return false;
        }
    }

}
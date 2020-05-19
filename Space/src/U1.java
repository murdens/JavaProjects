

public class U1 extends Rocket {

    U1(){
        rocketCost = 100; // million
        rocketWeight = 1000; // tonnes
        rocketMaxWeight = 1800;  // tonnes
        indexLaunchExplosion = 5; //5% *( cargo carried / cargo limit)
        indexLandCrash = 1; //1%*(cargo carried / cargo limit)
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
        double randomN = (Math.random() * 100);
        //System.out.println("random number: "+ randomN); //random number 0-99
        double succeed = indexLandCrash * (double) currentWeight / rocketMaxWeight;
        System.out.println("Probability of land succeeding=" + succeed);
        if (succeed <= randomN) {
            System.out.println("Landed successfully.");
            return true;
        } else {
            System.out.println("Rocket crashed when landing.");
            return false;
        }
    }
}
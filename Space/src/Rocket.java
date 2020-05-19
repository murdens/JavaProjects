public class Rocket implements SpaceShip {

    int rocketCost; // million
    int rocketWeight; // tonnes
    int rocketMaxWeight;  // tonnes
    int currentWeight;
    int indexLaunchExplosion ;
    int indexLandCrash;


    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
       if ((this.currentWeight + item.itemWeight) <= this.rocketMaxWeight) {
         System.out.println("Can carry");
           return true;
        }else {
           return false;
       }
    }

    @Override
    public int carry(Item item) {
       this.currentWeight += item.itemWeight;
       System.out.println("Carrying: "+this.currentWeight);
       return currentWeight;
    }


}
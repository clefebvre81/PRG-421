// Chris Lefebvre
// PRG/421 Week 1 - BicycleDemo
// June 11, 2018

class BicycleDemo {
    public static void main(String[] args) {

        // Create two instances each of MountainBike and RoadBike.
        Bicycle bike1 = new Bicycle.MountainBike();
        Bicycle bike2 = new Bicycle.MountainBike();
        Bicycle bike3 = new Bicycle.RoadBike();
        Bicycle bike4 = new Bicycle.RoadBike();

        // Invoke methods on the four objects
        bike1.changeCadence(50);
        bike1.speedUp(10);
        bike1.changeGear(2);
        ((Bicycle.MountainBike) bike1).setTireTread("Low Rolling Resistance");
        ((Bicycle.MountainBike) bike1).setMountainRating(3);
        bike1.printStates();

        bike2.changeCadence(40);
        bike2.speedUp(10);
        bike2.changeGear(3);
        ((Bicycle.MountainBike) bike2).setTireTread("Maximum Grip");
        ((Bicycle.MountainBike) bike2).setMountainRating(5);
        bike2.printStates();

        bike3.changeCadence(30);
        bike3.speedUp(5);
        bike3.changeGear(15);
        ((Bicycle.RoadBike) bike3).setMaximumMPH(35);
        bike3.printStates();

        bike4.changeCadence(35);
        bike4.speedUp(10);
        bike4.changeGear(10);
        ((Bicycle.RoadBike) bike4).setMaximumMPH(50);
        bike4.printStates();

        System.out.println("Total number of bikes: " + Bicycle.getbicycleCount());
    }
}
// Change the Bicycle class to be an abstract class.
abstract class Bicycle {
    /* Add a private variable of type integer named bicycleCount, and initialize
    this variable to 0.*/
    private static int bicycleCount = 0;
    int cadence = 0;
    int speed = 0;
    int gear = 1;

    /* Change the Bicycle constructor to add 1 to the bicycleCount each time a
    new object of type Bicycle is created. */
    Bicycle() {
        bicycleCount++;
    }

    // Add a public getter method to return the current value of bicycleCount.
    static int getbicycleCount() {
        return bicycleCount;
    }

    void changeCadence(int newValue) {
        cadence = newValue;
    }

    void changeGear(int newValue) {
        gear = newValue;
    }

    void speedUp(int increment) {
        speed = speed + increment;
    }

    void applyBrakes(int decrement) {
        speed = speed - decrement;
    }

    void printStates() {
        System.out.println("cadence:" +
                cadence + " speed:" +
                speed + " gear:" + gear);
    }

    /* Derive two classes from Bicycle: MountainBike and RoadBike. To the
MountainBike class, add the private variables tireTread (String) and
mountainRating (int). To the RoadBike class, add the private variable
maximumMPH (int). */
    static class MountainBike extends Bicycle {
        private String tireTread;
        private int mountainRating;

        // Method to set Tire Tread for each Mountain Bike object
        void setTireTread(String tread) {
            tireTread = tread;
        }

        // Method to set Mountain Rating for each Mountain Bike object
        void setMountainRating(int rating) {
            mountainRating = rating;
        }

        // Method to Print the States of each Mountain Bike object
        void printStates() {
            System.out.println("cadence:" +
                    cadence + " speed:" +
                    speed + " gear:" + gear +
                    " Tire Tread: " + tireTread +
                    " Mountain Rating: " + mountainRating);
        }
    }

    // Road Bike subclass with private variable maximumMPH
    static class RoadBike extends Bicycle {
        private int maximumMPH;

        // Method to set the maxMPH
        void setMaximumMPH(int mph) {
            maximumMPH = mph;
        }

        // Method to print the states of each road bike
        void printStates() {
            System.out.println("cadence:" +
                    cadence + " speed:" +
                    speed + " gear:" + gear +
                    " Max MPH: " + maximumMPH);
        }
    }
}

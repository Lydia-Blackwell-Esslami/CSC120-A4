public class Passenger implements PassengerRequirements{
    
    public String name;

    /**
     * Constructor for the passenger
     * @param name The passenger's name
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Calls the addPassenger method from the car class with the passenger as a paremeter in order to add them to the car
     * @param c The car the passenger will board
     */
    public void boardCar(Car c){
        if (c.addPassenger(this)){
            System.out.println("Boarded sucessfully");
        } else {
            System.out.println("The passenger was unable to board!");
        }
    }

    /**
     *Calls the removePassenger method from the car class with the passenger as a paremeter in order to remove them from the car
     * @param c The car the passenger will get out of
     */
    public void getOffCar(Car c){
        if (c.removePassenger(this)){
            System.out.println("Departed sucessfully");
        } else {
            System.out.println("The passenger could not get out!");
        }
    }

    public static void main(String[] args) {
       Passenger testPassenger1 = new Passenger("Barbra");
       Passenger testPassenger2 = new Passenger("Steve");
       //testPassenger1.boardCar(myCar);
    }
}

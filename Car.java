import java.util.ArrayList;

public class Car implements  CarRequirements{
    //Attributes
    public ArrayList<Passenger> passengers;
    private int maximumCapacity;

    /**
     * Constructor for the car
     * @param passengers The arraylist of passengers that are in the car
     * @param maximumCapacity The maximum capacity of the car
     */
    public Car(int maximumCapacity){
        this.passengers = new ArrayList<Passenger>(maximumCapacity);
        this.maximumCapacity = maximumCapacity;
    }

    /**
     * @return The maximum amount of people who can be in the car
     */
    public int getCapacity(){
        return this.maximumCapacity;
    }

    /**
     * @return The amount of empty seats on the train
     */
    public int seatsRemaining(){
        return (this.maximumCapacity - this.passengers.size());
    }


    /**
     * Checks if a given passenger is on the car. If they are not, it adds them to it. 
     * @param p The passenger object that will get on the car 
     * @return Wether or not the passenger is on the car
     */
    public Boolean addPassenger(Passenger p){
        if (this.maximumCapacity - this.passengers.size() >= 1){
        if (this.passengers.contains(p)){
            System.out.println("This passenger is already in the car");
            return false;
        } else {
            this.passengers.add(p);
        }
        return true;
    } else {
        System.out.println("The car is full!!!");
        return false;
    }
    }

    /**
     * Checks if a given passenger is in the car. If they are, it removes them. 
     * @param p The passenger that will get off the car
     * @return Wether or not the passenger is on the car
     */
    public Boolean removePassenger(Passenger p) {
        if (this.passengers.contains(p)){
            this.passengers.remove(p);
        } else {
            System.out.println("The passenger is not in the car!!");
            return false;
        }
        return true;
    }

    /**
     * Prints all of the passengers on the car
     */
    public void printManifest(){
        for (int i = 0; i < this.passengers.size(); i++) {
            Passenger passenger = this.passengers.get(i);
            String name = passenger.name;
            System.out.println(name);
        }
    }

    public String toString(){
        return("This car has a capacity of " + this.maximumCapacity + " people.");
    }

    public static void main(String[] args) {
        Passenger testPassenger4 = new Passenger("Bob");
        Car myCar = new Car (30);
        myCar.printManifest();
        myCar.toString();
        myCar.addPassenger(testPassenger4);
        System.out.println(myCar.toString());
        myCar.printManifest();
        System.out.println(myCar.toString());

    }




}

import java.util.ArrayList;


public class Train implements TrainRequirements {
    //Attributes
    private String name;
    private String[] stops;
    private Engine thisEngine;
    private ArrayList<Car> cars;


    /**
     * Contructor for the train
     * @param name The name of the train
     * @param stops List of stations where it will stop
     * @param engine The engine of the train
     */
    public Train(String name, String[] stops, Engine engine){
        this.name = name;
        this.stops = stops;
        this.thisEngine = engine;
        this.cars = new ArrayList<Car>();
    }

    /**
     * Acessor for the engine
     * @return The train engine
     */
    public Engine getEngine(){
        return this.thisEngine;
    }

    /**
     * Acessor for the train cars
     * @param i The index of the car to be acessed
     * @return  The specifed car
     */
    public Car getCar(int i){
        return this.cars.get(i);
    }

    /** 
     * Calculates the maximum capacity of the entire train
     * @return The sum of the maximum capacity of each car
    */
    public int getMaxCapacity(){
        int capacity = 0;
        for (int i = 0; i < (cars.size()); i++) {
            Car car = cars.get(i);
            capacity += car.getCapacity();
        }
        return capacity;
    }
    /**
     * Calculates the amount of unoccupied seats on the train
     * @return The difference between the total capacity and the current total number of passengers
     */
    public int seatsRemaining(){
        int capacity = getMaxCapacity();
        int num_passengers = 0;
        for (int i = 0; i < (cars.size()); i++) {
            Car car = cars.get(i);
            num_passengers += car.passengers.size();
        }
        return (capacity - num_passengers);
    }

    /**
     * Prints the name of every passenger on the train and what car they are in
     */
    public void printManifest(){
        for (int i = 0; i < (cars.size()); i++) {
            Car car = cars.get(i);
            car.printManifest();
        }
    }

    /**
     * It is supposed to make a string containing the list of all the stops, but currently does not work
     * @return The string "These are the stops: "
     */
    private String getStops(){
        String stopsString = "These are the stops: ";
        for (int q = 0; q <this.stops.length ; q++) {
            stopsString.concat(this.stops[q]);
            stopsString.concat(", ");
            System.out.println(stopsString);
        }
        return stopsString;
    }

    public String toString(){
        return ("This is train: " + this.name + ". It will stop at these stations: " + this.getStops() + 
        ". It has " +this.cars.size() + " many cars, and a maximum capacity of " + this.getMaxCapacity() + " many passengers.");
    }

    public static void main(String[] args) {
        String[] testStops = new String[] {"NHT", "BOS", "NYC", "PHI", "BAL", "WAS"};
        Engine testEngine = new Engine(FuelType.INTERNAL_COMBUSTION, 100,100 );
        ArrayList<Passenger> testPassengers = new ArrayList<Passenger>();
        Passenger testPassenger5 = new Passenger("Eric");
        testPassengers.add(testPassenger5);
        Train myTrain = new Train("Vermonter", testStops, testEngine);
        Car testCar1 = new Car("A70", testPassengers, 30);
        myTrain.cars.add(testCar1);
        System.out.println(myTrain.toString());
        //myTrain.getStops();
    }

}   

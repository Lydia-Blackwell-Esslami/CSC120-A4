
import java.util.ArrayList;


public class Train implements TrainRequirements {
    //Attributes
    private Engine thisEngine;
    private ArrayList<Car> cars;


    /**
     * Contructor for the train
     * @param name The name of the train
     * @param engine The engine of the train
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.thisEngine = new Engine(fuelType, 0.0, fuelCapacity);
        this.cars = new ArrayList<Car>(nCars);
        for (int i = 0; i < nCars; i++) {
            this.cars.add(new Car(passengerCapacity));
        }
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


    public String toString(){
        return ( "This train has " +this.cars.size() + "  cars, and a maximum capacity of " + this.getMaxCapacity() + " passengers.");
    }

    public static void main(String[] args) {
        Train myTrain = new Train (FuelType.INTERNAL_COMBUSTION, 100.0, 4, 100);
        System.out.println(myTrain.toString());
    }

}   

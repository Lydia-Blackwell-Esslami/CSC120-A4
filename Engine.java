public class Engine implements EngineRequirements {

    //Attributes

    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /**
     * Constructor for the Engine
     * @param f Fuel Type from FuelType.java
     * @param currentFuelLevel Amount of fuel in the train
     * @param maxFuelLevel Maximum amount of fuel that can be in the train
     */
    public Engine(FuelType f, double currentFuelLevel, double maxFuelLevel){
        this.f = f;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }
    /**
     * @return The fuel type of the train
     */
    public FuelType getFuelType(){
        return this.f;
    }


    /**
     * @return The maximum fuel level of the train
     */
    public double getMaxFuel(){
        return this.maxFuelLevel;
    }

    /**
     * @return The current fuel level of the tain
     */
    public double getCurrentFuel(){
        return this.currentFuelLevel;
    }
    /**
     * Refuels the train to the maximum fuel level
     */
    public void refuel(){
        this.currentFuelLevel = this.maxFuelLevel;
    }

    /**
     * Drives the train
     * @return If there is any more fuel in the train
     */
    public Boolean go(){
        if (this.currentFuelLevel >= 50){
            this.currentFuelLevel -= 50;
        }
        System.out.println("Current Fuel: "+ this.currentFuelLevel);
        return (this.currentFuelLevel > 0);
    }

    public String toString(){
        return("Engine has fuel type: " + this.f +". Current fuel level: "+ this.currentFuelLevel+ ". Maximum fuel level: " + this.maxFuelLevel);
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.STEAM, 100.0, 100.0);
        System.out.println(myEngine);
        myEngine.go();
        myEngine.go();
        System.out.println(myEngine);
        myEngine.refuel();
        System.out.println(myEngine);

    }

}
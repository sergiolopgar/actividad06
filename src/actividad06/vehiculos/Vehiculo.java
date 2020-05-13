
package actividad06.vehiculos;

import static actividad06.GestionVehiculos.blue;
import static actividad06.GestionVehiculos.reset;

/**
 *
 * @author sergionicolaslopezgarcia
 */
public abstract class Vehiculo implements IVehiculo {
    private String licensePlate;
    private String model;
    private int numSeats;
    private int numberDaysRented;
    
    /**
     *Constructor for Vehicule.
     * @param licensePlate License plate of the car
     * @param model Model of the car
     * @param numSeats Number of seats of the car
     * @param numberDaysRented Numbers of days the car is rented
     */
    public Vehiculo(String licensePlate, String model, int numSeats, int numberDaysRented) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.numSeats = numSeats;
        this.numberDaysRented = numberDaysRented;
    }
    
    /**
     *Default Constructor for Vehicule. Sets the attributes to 0 or ""
     */
    public Vehiculo() {
        this.licensePlate = "";
        this.model = "";
        this.numSeats = 0;
        this.numberDaysRented = 0;
    }
    
    /**
     *Getter for the vehicule's license plate.
     * @return The license plate of the vehicule
     */
    public String getLicense() {
        return licensePlate;
    }
    
    /**
     *Setter for the vehicule's license.
     * @param license Value to be assign in licensePlate
     */
    public void setLicense(String license) {
        this.licensePlate = license;
    }
    
    /**
     *Getter for the vehicule's model.
     * @return The model of the vehicule
     */
    public String getModel() {
        return model;
    }
    
    /**
     *Setter for the vehicule's model.
     * @param model Value to be assign in model
     */
    public void setModel(String model) {
        this.model = model;
    }
    
    /**
     *Getter for the vehicule's number of seats.
     * @return The number of seats of the vehicule
     */
    public int getNumSeats() {
        return numSeats;
    }
    
    /**
     *Setter for the vehicule's number of seats.
     * @param numSeats Value to be assign in numSeats
     */
    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
    
    /**
     *Getter for the number of days the car is rented.
     * @return The days of the rental
     */
    public int getNumberDaysRented() {
        return this.numberDaysRented;
    }
    
     /**
     *Setter for the number of days the car is rented. Override the Interface IVehiculo method
     * @param days Value of days to be store
     */
    @Override
    public void setNumberDaysRented(int days) {
        this.numberDaysRented = days;    
    }
    
    /**
     *Getter for the total price of the rental.Override the Interface IVehiculo method
     * @return the total price for the rental of the car
     */
    @Override
    public double getTotalPriceOfRent() {
        return (IVehiculo.basePrice * this.numberDaysRented); 
    }
    
    /**
     *Method to display the info of the vehicule. Override the Interface IVehiculo method
     * @param color Color for printing in the console
     */
    @Override
    public void displayInfo(String color) {
        System.out.println(color + "- Matricula: " + reset + this.licensePlate);
        System.out.println(color + "- Modelo: " + reset + this.model);
        System.out.println(color + "- Número de plazas: " + reset + this.numSeats);
        System.out.println(color + "- Cantidad de días de alquiler: " + reset + this.numberDaysRented);
        System.out.println(color + "- Precio base por día: " + reset + IVehiculo.basePrice + "€");
        System.out.println(color + "- Coste total del alquiler: " + reset + this.getTotalPriceOfRent() + "€");
    }
    
    /**
     *Setter for the vehicule's attributes, calling the verifiers methods. Override the Interface IVehiculo method 
     */
    @Override
    public void askInfo() {
        this.setLicense(VehiculoVerifications.validPlateAsk());
        this.setModel(VehiculoVerifications.validModelAsk());
        this.setNumSeats(VehiculoVerifications.validSeatsAsk());
        this.setNumberDaysRented(VehiculoVerifications.validDaysAsk());
    }
    
    /**
     *toString method for the vehicule's basic info, overriding the toString method of the interface
     * @return The baic info of the car
     */
    @Override
    public String toString() {
        return  blue + "Modelo: " + reset + this.getModel() + " - " + blue;
    }
}

    
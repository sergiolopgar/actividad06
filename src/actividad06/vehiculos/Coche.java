
package actividad06.vehiculos;

import static actividad06.GestionVehiculos.reset;

/**
 *
 * @author sergionicolaslopezgarcia
 */
public class Coche extends Vehiculo  {
    
    //Enum with the valid options for the car's gama
    public enum Gama {
        A,
        B,
        C,
        D
    }
    
    private Gama gama;
    
    /**
     *Constructor for Coche.
     * @param licensePlate License plate of the car
     * @param model Model of the car
     * @param numSeats Number of seats of the car
     * @param numberDaysRented Numbers of days the car is rented
     * @param gama gama for the car
     */
    public Coche(String licensePlate, String model, int numSeats, int numberDaysRented, Gama gama) {
        super(licensePlate, model, numSeats, numberDaysRented);//Call for the constructor of the super class (Vehiculo)
        this.gama = gama;
    }
    
    /**
     *Default Constructor for Coche. Sets the attributes to 0 or "" and gama to null
     */
    public Coche() {
        super();//Call for the default constructor of the super class (Vehiculo)
        this.gama = null;
    }
    
    /**
     *Getter for the car's gama.
     * @return The gama of the car
     */
    public Gama getGama() {
        return this.gama;
    }
    
    /**
     *Setter for the car's gama.
     * @param gama the gama of the car
     */
    public void setGama(Gama gama) {
        this.gama = gama;
    }
    
    /**
     *toString method for the car's basic info, calling the toString method to its super class
     * @return The baic info of the car
     */
    @Override
    public String toString() {
        return super.toString() + "Gama: " + reset + this.getGama();
    }
    
    /**
     *Getter for the total price of the rental.Override the Interface IVehiculo method
     * @return the total price for the rental of the car
     */
    @Override
    public double getTotalPriceOfRent() {
        return super.getTotalPriceOfRent() + ((super.getNumSeats() + super.getNumberDaysRented()) * 1.5); 
    }
    
    /**
     *Method to display the info of the car. Override the Interface IVehiculo method
     * @param color Color for printing in the console
     */
    @Override
    public void displayInfo(String color) {
        System.out.println(color + "- Gama: " + reset + this.gama.toString());
        super.displayInfo(color);
    }
    
    /**
     *Setter for the car's attributes, calling the verifiers methods. Override the Interface IVehiculo method 
     */
    @Override
    public void askInfo() {
        super.askInfo();
        this.setGama(VehiculoVerifications.validGamaAsk());
    }
}


package actividad06.vehiculos;

import static actividad06.GestionVehiculos.reset;

/**
 *
 * @author sergionicolaslopezgarcia
 */
public class Carga extends Vehiculo {
    private double pMA;
    
    /**
     *Constructor for Carga.
     * @param licensePlate License plate of the carga vehicule
     * @param model Model of the carga vehicule
     * @param numSeats Number of seats of the carga vehicule
     * @param numberDaysRented Numbers of days the carga vehicule is rented
     * @param pMa Max weigth permitted
     */
    public Carga(String licensePlate, String model, int numSeats, int numberDaysRented, double pMa) {
        super(licensePlate, model, numSeats, numberDaysRented);//Call for the constructor of the super class (Vehiculo)
        this.pMA = pMa;
    }
    
    /**
     *Default Constructor for Carga. Sets the attributes to 0 or "" 
     */
    public Carga() {
        super();//Call for the default constructor of the super class (Vehiculo)
        this.pMA = 0;
    }
    
    /**
     *Getter for the carga vehicule's Max weigth permitted.
     * @return The max weigth
     */
    public double getPMA() {
        return this.pMA;
    }
    
    /**
     *Setter for the carga vehicule's Max weigth permitted.
     * @param pMA The max weigth to store
     */
    public void setPMA(double pMA) {
        this.pMA = pMA;
    }
    
    /**
     *toString method for the carga vehicule's basic info, calling the toString method to its super class
     * @return The basic info of the carga vehicule
     */
    @Override
    public String toString() {
        return super.toString() + "Peso Máximo (Toneladas): " + reset + this.getPMA();
    }
    
    /**
     *Getter for the total price of the rental.Override the Interface IVehiculo method
     * @return the total price for the rental of the carga vehicule
     */
    @Override
    public double getTotalPriceOfRent() {
        return ((IVehiculo.basePrice + (20 * this.pMA)) * super.getNumberDaysRented()); 
    }
    
    /**
     *Method to display the info of the carga vehicule.Override the Interface IVehiculo method
     * @param color Color for printing in the console
     */
    @Override
    public void displayInfo(String color) {
        System.out.println(color + "- Peso Máximo (Toneladas): " + reset + this.pMA);
        super.displayInfo(color);
    }
    
    /**
     *Setter for the carga vehicule's attributes, calling the verifiers methods. Override the Interface IVehiculo method 
     */
    @Override
    public void askInfo() {
        super.askInfo();
        this.setPMA(VehiculoVerifications.validPMAAsk());
    }
}

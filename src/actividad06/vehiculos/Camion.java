
package actividad06.vehiculos;

import static actividad06.GestionVehiculos.blue;
import static actividad06.GestionVehiculos.reset;

/**
 * @author sergionicolaslopezgarcia
 */
public class Camion extends Carga {
    //Enum with the valid options for the truck's structure
    public enum Structure {
        RIGIDO,
        REMOLQUE,
        SEMIRREMOLQUE
    }
    
    private Structure structure;
    
    /**
     *Constructor for Camion.
     * @param licensePlate License plate of the carga vehicule
     * @param model Model of the carga vehicule
     * @param numSeats Number of seats of the carga vehicule
     * @param numberDaysRented Numbers of days the carga vehicule is rented
     * @param pMa Max weigth permitted
     * @param structure structure of the truck
     */
    public Camion(String licensePlate, String model, int numSeats, int numberDaysRented, double pMa, Structure structure) {
        super(licensePlate, model, numSeats, numberDaysRented, pMa);
        this.structure = structure;
    }
    
    /**
     *Default Constructor for Carga. Sets the attributes to 0 or "", and structure to null 
     */
    public Camion() {
        super();
        this.structure = null;
    }
    
    /**
     *Getter for the truck's structure
     * @return The structure of the truck
     */
    public Structure getStructure() {
        return this.structure;
    }
    
    /**
     *Setter for the truck's structure
     * @param structure The structure of the truck
     */
    public void setStructure(Structure structure) {
        this.structure = structure;
    }
    
    /**
     *toString method for the truck basic info, calling the toString method to its super class
     * @return The basic info of the truck
     */
    @Override
    public String toString() {
        return blue + "Modelo: " + reset + super.getModel() + " - " + blue + "Estructura: " + reset + this.getStructure();
    }
    
    /**
     *Getter for the total price of the rental.
     * @return the total price for the rental of the truck
     */
    @Override
    public double getTotalPriceOfRent() {
        return super.getTotalPriceOfRent() + 40; 
    }
    
    /**
     *Method to display the info of the truck.
     * @param color Color for printing in the console
     */
    @Override
    public void displayInfo(String color) {
        System.out.println(color + "- Estructura: " + reset + this.getStructure().toString());
        super.displayInfo(color);
    }
    
    /**
     *Setter for the truck's attributes, calling the verifiers methods.
     */
    @Override
    public void askInfo() {
        super.askInfo();
        this.setStructure(VehiculoVerifications.validStructureAsk());
    }
}

//Toolkit para el sonido en los errores
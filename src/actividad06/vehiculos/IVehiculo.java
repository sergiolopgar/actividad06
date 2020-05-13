
package actividad06.vehiculos;

/**
 *
 * @author sergionicolaslopezgarcia
 */
public interface IVehiculo {
    void setNumberDaysRented(int days);
    double getTotalPriceOfRent();
    void displayInfo(String color);
    void askInfo();
    double basePrice = 50;
}

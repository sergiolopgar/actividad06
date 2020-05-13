
package actividad06.vehiculos;

import actividad06.pideDatos.DisplayAndMessages;
import static actividad06.GestionVehiculos.blue;
import static actividad06.GestionVehiculos.green;
import static actividad06.GestionVehiculos.line;
import static actividad06.GestionVehiculos.red;
import static actividad06.GestionVehiculos.star;
import static actividad06.GestionVehiculos.vehiculeList;
import java.awt.Toolkit;

/**
 *
 * @author sergionicolaslopezgarcia
 */
public class VehiculoOps {
    /**
    * Method that create a new instance of Coche, add it to the list of vehicules, and display its info
    */
    public static void createCar() {
        DisplayAndMessages.deco("Has elegido ingresar un nuevo coche. Comenzamos?", blue, star);
        Coche car = new Coche();//Create a new instance of Coche with the default constructor
        car.askInfo();//Sets all the attributes of the new car calling its askInfo() method
        DisplayAndMessages.deco(DisplayAndMessages.wellDoneMessage("creado", "el coche"), green, star);
        DisplayAndMessages.deco("En qué posición te gustaría guardarlo? Introduce un número entre 1-" + vehiculeList.length + ", y presiona Enter: ", blue, star);
        DisplayAndMessages.displayVehiculeList();//Display the list of vehicules available
        int choice = VehiculoVerifications.overWriteVehicule(VehiculoVerifications.validPositionAsk());//Ask for a position in the list to store the car
        vehiculeList[choice] = car;//Store the car in the position chosen by the user
        DisplayAndMessages.deco(DisplayAndMessages.wellDoneMessage("guardado", " el coche"), green, star);
        DisplayAndMessages.deco("Aquí tienes los datos del coche que acabas de introducir:", green, line);
        car.displayInfo(green);//Display the info of the new car calling its displayInfo() method
    }
    
    /**
    * Method that create a new instance of Carga, add it to the list of vehicules, and display its info
    */
    public static void createCarga() {
        DisplayAndMessages.deco("Has elegido ingresar un nuevo vehiculo de carga. Comenzamos?", blue, star);
        Carga carga = new Carga();//Create a new instance of Carga with the default constructor
        carga.askInfo();//Sets all the attributes of the new carga vehicule calling its askInfo() method
        DisplayAndMessages.deco(DisplayAndMessages.wellDoneMessage("creado", " el vehiculo de carga"), green, star);
        DisplayAndMessages.deco("En qué posición te gustaría guardarlo? Introduce un número entre 1-" + vehiculeList.length + ", y presiona Enter: ", blue, star);
        DisplayAndMessages.displayVehiculeList();//Display the list of vehicules available
        int choice = VehiculoVerifications.overWriteVehicule(VehiculoVerifications.validPositionAsk());//Ask for a position in the list to store the carga vehicule
        vehiculeList[choice] = carga;//Store the carga vehicule in the position chosen by the user
        DisplayAndMessages.deco(DisplayAndMessages.wellDoneMessage("guardado", " el vehiculo de carga"), green, star);
        DisplayAndMessages.deco("Aquí tienes los datos del vehiculo de carga que acabas de introducir:", green, line);
        carga.displayInfo(green);//Display the info of the new carga vehicule calling its displayInfo() method
    }
    
    /**
    * Method that create a new instance of Camion, add it to the list of vehicules, and display its info
    */
    public static void createCamion() {
        DisplayAndMessages.deco("Has elegido ingresar un nuevo camión. Comenzamos?", blue, star);
        Camion truck = new Camion();//Create a new instance of Camion with the default constructor
        truck.askInfo();//Sets all the attributes of the new truck calling its askInfo() method
        DisplayAndMessages.deco(DisplayAndMessages.wellDoneMessage("creado", " el camión"), green, star);
        DisplayAndMessages.deco("En qué posición te gustaría guardarlo? Introduce un número entre 1-" + vehiculeList.length + ", y presiona Enter: ", blue, star);
        DisplayAndMessages.displayVehiculeList();//Display the list of vehicules available
        int choice = VehiculoVerifications.overWriteVehicule(VehiculoVerifications.validPositionAsk());//Ask for a position in the list to store the truck
        vehiculeList[choice] = truck;//Store the truck in the position chosen by the user
        DisplayAndMessages.deco(DisplayAndMessages.wellDoneMessage("guardado", " el camión"), green, star);
        DisplayAndMessages.deco("Aquí tienes los datos del camión que acabas de introducir:", green, line);
        truck.displayInfo(green);//Display the info of the new truck calling its displayInfo() method
    }
    
    /**
    * Method that displays the list of vehicules if any, ask the user to choose one, and this case, displays the info of that vehicule
     * @param string Phrase depending which method is calling it
     * @return the choice of the user (number)
    */
    public static int displayOneVehicule(String string) {
        int choice = -1;
        if(VehiculoVerifications.noVehicules()) {//Displays if there are no vehicules in the list
            DisplayAndMessages.deco("No tienes ningún vehiculo disponible. Introduce alguno primero, e intentalo nuevamente.", red, star);
            Toolkit.getDefaultToolkit().beep();//Sound for the error
        } else {
            DisplayAndMessages.deco("Estos son los vehiculos disponibles. " + string, blue, star);
            DisplayAndMessages.displayVehiculeList();//Display the list of vehicules available
            boolean exit = false;
            while(!exit) {
                choice = VehiculoVerifications.validPositionAsk();//Ask for a vehicule, and will keep asking till the user enters a valid option
                try {
                    DisplayAndMessages.deco("Aquí tienes los datos del vehiculo seleccionado:", blue, star);
                    vehiculeList[choice].displayInfo(blue);//Display the info of the vehicule calling its displayInfo() method
                    exit = true;
                } catch (NullPointerException ex) {//Displays if the option chosen is not valid
                    DisplayAndMessages.deco("No tienes ningún vehiculo en esa posición. Elige alguna opción que contenga un vehiculo para mostrar sus datos", red, star);
                    Toolkit.getDefaultToolkit().beep();//Sound for the message
                    DisplayAndMessages.displayVehiculeList();
                }   
            }
        }
        return choice;
    }
    
    /**
    * Method that changes the quantity of days rented of a vehicule
    */
    public static void changeDaysRented() {
        int choice = displayOneVehicule("A cuál le quieres modificar los días de alquiler?");//Call to displayOneVehicule to display the list of vehicules and ask to choose one
        if(choice >= 0) {//Enters if there are vehicules in the list
            vehiculeList[choice].setNumberDaysRented(VehiculoVerifications.validDaysAsk());//Sets the number of days for the rental after checking is valid
            DisplayAndMessages.deco(DisplayAndMessages.wellDoneMessage("modificado", " la cantidad de días de alquiler"), green, star);
            vehiculeList[choice].displayInfo(green);//Display the info of the vehicule calling its displayInfo() method 
        }
    }
    
    /**
    * Method that displays the info of all the vehicules in the list
    */
    public static void displayAllVehicules() {
        if(VehiculoVerifications.noVehicules()) {//Enter if there are no vehicules in the list
            DisplayAndMessages.deco("No tienes ningún vehiculo disponible. Introduce alguno primero, e intentalo nuevamente.", red, star);
        } else {//Enters if there are vehicule in the list
            DisplayAndMessages.deco("Aquí tienes los datos de tus vehiculos:", blue, star);
            for (IVehiculo vehicule : vehiculeList) {//For each vehicule in the list
                try {
                    DisplayAndMessages.deco("Tipo:" + vehicule.getClass().getSimpleName().toUpperCase(), blue, line);
                    vehicule.displayInfo(blue);//Display the info of the vehicule calling its displayInfo() method
                }catch (NullPointerException ex) {
                }
            }
        }
    }
}

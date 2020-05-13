
package actividad06.pideDatos;

import static actividad06.GestionVehiculos.blue;
import static actividad06.GestionVehiculos.reset;
import static actividad06.GestionVehiculos.star;
import static actividad06.GestionVehiculos.vehiculeList;
import java.io.IOException;


/**
 * @author sergionicolaslopezgarcia
 */
public class DisplayAndMessages {
    
    /**
     *Method to print the decoration frame and text in between. The large of the frame changes depending the string to print
     * @param string String to be printed between frame
     * @param color Color of the frame
     * @param deco Shape of the frame stars or lines
     */
    public static void deco(String string, String color, String deco) {
        for(int i = 0; i <= string.length(); i++) {
            System.out.print(color + deco);
        }
        
        System.out.println("");
        System.out.println(color + string);
        
        for(int i = 0; i <= string.length(); i++) {
            System.out.print(color + deco + reset);
        }
        
        System.out.println("" + reset);
    }
    
     /**
     *Display the main menu calling the method InputAndMessages.deco()
     */
    public static void menuDisplay(){
        DisplayAndMessages.deco("Elige la operacion que quieras realizar o bien la opción 7 para salir: ", blue, star);
        System.out.println("1. Crear nuevo Coche");
        System.out.println("2. Crear nuevo Vehiculo de Carga");
        System.out.println("3. Crear nuevo Camión");
        System.out.println("4. Mostrar info de un vehiculo");
        System.out.println("5. Modificar días de alquiler de un vehiculo y ver nuevo precio");
        System.out.println("6. Mostrar todos los vehiculos de la flota");
        System.out.println("7. Salir");
    }
    
    public static void displayVehiculeList() {
        for(int i = 0; i < vehiculeList.length; i++) {
            try {
                System.out.println((i+1) + "." + blue + " Clase: " + reset + vehiculeList[i].getClass().getSimpleName().toUpperCase() + " - " + vehiculeList[i].toString());
            } catch (NullPointerException ex) {
                System.out.println((i+1) + ". No hay ningún vehiculo en esta posición");
            }
        }
    }
    
    /**
     *Error message when the input is empty or blank
     * @param target
     *@return Error message for empty or blank input
     */
    public static String emptyInput(String target) {
        return "No has introducido nada. Por favor, introduce " + target +  " y presiona Enter!";
    }
    
    /**
     *Message to confirm the action was done
     * @param target What is changing: car, carga vehicule, truck
     * @param action Verb depending which method is called from
     *@return Confirmation message 
     */
    public static String wellDoneMessage(String action, String target) {
        return "Bien hecho! ... Has " + action + target + " exitosamente" ;
    }
    
    /**
     *Error message when the input is not a number
     *@return Error message 
     */
    public static String numErrorMessage(){
        return "No has introducido un número!!! ... Por favor, ingresa un número y presiona la tecla Enter:";
    }
    
    /**
     *Error message when the user chooses an invalid option of the menu
     *@return Error message 
     */
    public static String invalidOptionMenu(){
        return "Has elegido una opcion invalida!!! ... Por favor, ingresa un número entre 1-5 y presiona la tecla Enter: ";
    }
    
    /**
     *Error message when the user chooses an invalid option from the files availables
     *@return Error message 
     */
    public static String invalidOptionAndRepeat() {
        return "Has elegido una opcion invalida!!! ... Por favor, escoge una opción válida y presiona la tecla Enter: ";
    }
    
    /**
     *Error message for IOException exception
     * @param ex The IOException caught
     *@return Error message 
     */
    public static String messageIoExcp(IOException ex) {
        return "Uuppss!!! ... Parece que ha ocurrido un error! ... Error: " + ex.getMessage();
    }
    
    /**
     *Message after user dicides to exit the program by pressing 7
     *@return farewell message 
     */
    public static String byeMessage(){
        return "Muchas gracias por tu tiempo! Que tengas buen dia y esperamos verte pronto nuevamente!";
    }
}


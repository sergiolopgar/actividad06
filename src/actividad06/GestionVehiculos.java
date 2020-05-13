
package actividad06;

import actividad06.vehiculos.VehiculoOps;
import actividad06.pideDatos.DisplayAndMessages;
import actividad06.pideDatos.Pregunta;
import actividad06.vehiculos.IVehiculo;
import actividad06.vehiculos.Vehiculo;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sergionicolaslopezgarcia
 */
public class GestionVehiculos {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String red="\033[31m"; 
    public static String reset="\u001B[0m";
    public static String green="\033[32m"; 
    public static String blue="\033[34m";
    public static String star="*";
    public static String line="-";
    public static IVehiculo[] vehiculeList = new Vehiculo[4];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int menuOption;// User's option for the menu
        
        do {
            DisplayAndMessages.menuDisplay();//Display the menu
            menuOption = Pregunta.isNumInt();//Menu option entered by the user calling isNumInt()
            
            switch(menuOption) {
                case 1 :
                    VehiculoOps.createCar();
                break;
                case 2 :
                    VehiculoOps.createCarga();
                break;
                case 3 :
                    VehiculoOps.createCamion();
                break;
                case 4 :
                    VehiculoOps.displayOneVehicule("De cuál quieres ver sus datos?");
                break;
                case 5 :
                    VehiculoOps.changeDaysRented();
                break;
                case 6 :
                    VehiculoOps.displayAllVehicules();
                break;
                case 7 :
                    DisplayAndMessages.deco(DisplayAndMessages.byeMessage(), blue, star);//Display farewell message if user decides to exit by pressing 7
                break;
                default :
                    DisplayAndMessages.deco(DisplayAndMessages.invalidOptionMenu(), red, star);//Display error message if the user chooses an invalid option
                    Toolkit.getDefaultToolkit().beep();//Sound when there is an error with the option
            }
        } while(menuOption != 7);
    }
}

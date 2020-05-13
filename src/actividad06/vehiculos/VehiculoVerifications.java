
package actividad06.vehiculos;

import actividad06.pideDatos.DisplayAndMessages;
import static actividad06.GestionVehiculos.blue;
import static actividad06.GestionVehiculos.br;
import static actividad06.GestionVehiculos.line;
import static actividad06.GestionVehiculos.red;
import static actividad06.GestionVehiculos.star;
import static actividad06.GestionVehiculos.vehiculeList;
import actividad06.pideDatos.Pregunta;
import actividad06.vehiculos.Coche.Gama;
import java.awt.Toolkit;
import java.io.IOException;

/**
 *
 * @author sergionicolaslopezgarcia
 */
public class VehiculoVerifications {
    
    /**
    * Method to ask to choose the gama of the car and will keep asking till the chosen one is valid
    * @return the gama of the car 
    */
    public static Gama validGamaAsk() {
        Gama gama = null;
        boolean exit = false;
        int opt;
        DisplayAndMessages.deco("Gama del coche (elige la opción entre 1-4:", blue, line);
        System.out.println("1. Gama A");
        System.out.println("2. Gama B");
        System.out.println("3. Gama C");
        System.out.println("4. Gama D");
        
        do {
            opt = Pregunta.isNumInt();
            switch (opt) {
                case 1:
                    gama = Gama.A;
                    exit = true;
                    break;
                case 2:
                    gama = Gama.B;
                    exit = true;
                    break;
                case 3:
                    gama = Gama.C;
                    exit = true;
                    break;
                case 4:
                    gama = Gama.D;
                    exit = true;
                    break;
                default:
                    DisplayAndMessages.deco("Uups ... creo que has introducido una opción de gama incorrecta. Por favor, introduce un número entre 1-4, y presione Enter:", red, star);
                    Toolkit.getDefaultToolkit().beep();
            }
        } while(!exit);
        return gama;
    }
    
    /**
    * Method that asks to introduce the license plate of the vehicule and will keep asking till the one entered is valid
    * @return the license plate of the vehicule in upper case
    */
    public static String validPlateAsk() {
        String plate = "";
        try {
            DisplayAndMessages.deco("Matricula (4 números y 3 consonantes, por ejemplo: 1234SBC):", blue, line);
            plate = br.readLine();
            while(!plate.toUpperCase().matches("^[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}$")) {//License plata needs to have 4 numbers and 3 letters
                if(plate.equals("") || plate.equals(" ")) {//Enters if the input is blank or empty
                    DisplayAndMessages.deco(DisplayAndMessages.emptyInput("una matrícula válida"), red, star);
                    Toolkit.getDefaultToolkit().beep();//Sound for the error
                } else {//Enters if the format is not valid
                    DisplayAndMessages.deco("Has intrucido una matrícula inválida. Por favor, vuelve a introducir la matrícula y presiona Enter:", red, star);
                    Toolkit.getDefaultToolkit().beep();//Sound for the error
                }
                plate = br.readLine();//Ask again for a license plate till the user introduces a valid one
            }
            for(IVehiculo item : vehiculeList) {
                Vehiculo vehicule = (Vehiculo) item;
                if(vehicule != null && vehicule.getLicense().equalsIgnoreCase(plate)) {//Checks if the license is not registered
                    DisplayAndMessages.deco("Esta matricula ya se encuentra registrada. Vuelve a introducir la matricula y presiona Enter:", red, star);
                    plate = validPlateAsk();
                }
            }
        } catch (IOException ex) {
            DisplayAndMessages.deco(DisplayAndMessages.messageIoExcp(ex), red, star);
            Toolkit.getDefaultToolkit().beep();//Sound for the error
        }
        return plate.toUpperCase();
    }
    
    /**
    * Method that asks to introduce the model of the vehicule and will keep asking if the input is blank or empty
    * @return the model of the vehicule in upper case
    */
    public static String validModelAsk() {
        String model = "";
        try {
            DisplayAndMessages.deco("Modelo:", blue, line);
            model = br.readLine();
            while(model.equals("") || model.equals(" ")) {
                DisplayAndMessages.deco(DisplayAndMessages.emptyInput("el modelo del coche"), red, star);
                Toolkit.getDefaultToolkit().beep();//Sound for the error
                model = br.readLine();
            }
        } catch (IOException ex) {
            DisplayAndMessages.deco(DisplayAndMessages.messageIoExcp(ex), red, star);
            Toolkit.getDefaultToolkit().beep();//Sound for the error
        }
        return model.toUpperCase();
    }
    
    /**
    * Method that asks to introduce the number of seats of the vehicule and will keep asking till the value is valid (between 2-7)
    * @return the number of seats of the vehicule
    */
    public static int validSeatsAsk() {
        int seats = 0;
        boolean exit = false;
        DisplayAndMessages.deco("Número de plazas:", blue, line);
        while(!exit) {
            seats = Pregunta.isNumInt();
            if(seats < 2 || seats > 7) {
                DisplayAndMessages.deco("Uups ... creo que has introducido una cantidad de asientos incorrecta. Por favor, vuelve a introducir cuantos asientos tiene el coche:", red, star);
                Toolkit.getDefaultToolkit().beep();//Sound for the error
            } else {
                exit = true;
            }
        }
        return seats;
    }
    
    /**
    * Method that asks to introduce the number of days the vehicule is rented and will keep asking till the value is valid (more than 0)
    * @return the number of days the vehicule is rented
    */
    public static int validDaysAsk() {
        int days = 0;
        boolean exit = false;
        DisplayAndMessages.deco("Días de alquiler:", blue, line);
        while(!exit) {
            days = Pregunta.isNumInt();
            if(days <= 0) {
                DisplayAndMessages.deco("Uups ... creo que has introducido una cantidad incorrecta de días. Por favor, vuelve a introducir cuantos días de alquiler tiene el coche:", red, star);
                Toolkit.getDefaultToolkit().beep();//Sound for the error
            } else {
                exit = true;
            }
        }
        return days;
    }
    
    /**
    * Method that asks to introduce the maximum weight permitted of the vehicule and will keep asking till the value is valid (0-17)
    * @return the maximum weight permitted of the vehicule
    */
    public static double validPMAAsk() {
        double pMA = 0;
        boolean exit = false;
        DisplayAndMessages.deco("Peso Máximo autorizado (en toneladas):", blue, line);
        while(!exit) {
            pMA = Pregunta.isNumDouble();
            if(pMA <= 0 || pMA > 17) {
                DisplayAndMessages.deco("Uups ... creo que has introducido una cantidad incorrecta. Por favor, vuelve a introducir el Peso Máximo autorizado:", red, star);
                Toolkit.getDefaultToolkit().beep();//Sound for the error
            } else {
                exit = true;
            }
        }
        return pMA;
    }
    
    /**
    * Method to ask to choose the structure of the truck and will keep asking till the chosen one is valid
    * @return the structure of the truck 
    */
    public static Camion.Structure validStructureAsk() {
        Camion.Structure structure = null;
        boolean exit = false;
        int opt;
        DisplayAndMessages.deco("Estructura del camión (elige la opción entre 1-3:", blue, line);
        System.out.println("1. Rígido");
        System.out.println("2. Remolque");
        System.out.println("3. Semirremolque");
        do {
            opt = Pregunta.isNumInt();
            switch (opt) {
                case 1:
                    structure = Camion.Structure.RIGIDO;
                    exit = true;
                    break;
                case 2:
                    structure = Camion.Structure.REMOLQUE;
                    exit = true;
                    break;
                case 3:
                    structure = Camion.Structure.SEMIRREMOLQUE;
                    exit = true;
                    break;
                default:
                    DisplayAndMessages.deco("Uups ... creo que has introducido una opción de estructura incorrecta. Por favor, introduce un número entre 1-3, y presione Enter:", red, star);
                    Toolkit.getDefaultToolkit().beep();//Sound for the error
            }
        } while(!exit);
        return structure;
    }
    
    /**
    * Method that asks and checks for a position in the list, and will keep asking till the value is valid (1-4)
    * @return the position chosen by the user 
    */
    public static int validPositionAsk() {
        int position = Pregunta.isNumInt() - 1;
        while(position < 0 || position >= vehiculeList.length) {
            DisplayAndMessages.deco("Uups ... creo que has introducido una opción incorrecta. Por favor, introduce un número entre 1-" + vehiculeList.length + " y presiona Enter:", red, star);
            Toolkit.getDefaultToolkit().beep();//Sound for the error
            position = Pregunta.isNumInt() - 1;
        }
        return position;
    } 
    
    /**
    * Method that iterates through the list of vehicules to check if there are vehicules or not
    * @return true if the list is empty or false if there is at least one vehicule in the list 
    */
    public static boolean noVehicules() {
        boolean empty = true;
        for(IVehiculo vehicule : vehiculeList) {
            if(vehicule != null) {
                empty = false;
            }
        }
        return empty;
    }
    
    /**
    * Method that verifies if there is a vehicule in the position chosen by the user. If that the case, ask if an overwrite is wanted. else asks for another position
     * @param choice the position selected by the user
    * @return the choice of the user
    */
    public static int overWriteVehicule(int choice) {
        int opt;
        int counter = 0;
        boolean exit = false;
        if(vehiculeList[choice] == null) {//returns the choice and exit if there is no vehicule in that position
            return choice;
        } else {
            DisplayAndMessages.deco("Tienes un vehiculo en esta posición. Deseas sobreescribirlo?", red, star);
            System.out.println("1. Si");
            System.out.println("2. No");
            
            do {
                if(counter == 0) {//Only ask the first time
                   opt = Pregunta.isNumInt(); 
                } else {//Displays and ask later if the user chosed an invalid option
                   DisplayAndMessages.deco("Deseas sobreescribirlo?", blue, star);
                    System.out.println("1. Si");
                    System.out.println("2. No"); 
                    opt = Pregunta.isNumInt(); 
                }
                
                switch (opt) {
                    case 1://If chooses to overwrite, displays the message and return the position chosen
                        DisplayAndMessages.deco("Has elegido sobreescribir tu vehiculo!", blue, star);
                        return choice;
                    case 2://If chooses not to overwrite
                        DisplayAndMessages.deco("Elige otra posición para tu nuevo vehiculo:", blue, star);
                        DisplayAndMessages.displayVehiculeList();//Displays the list of vehicules
                        choice = overWriteVehicule(validPositionAsk());//Recursive call to ask for a new position
                        exit = true;
                        break;
                    default:
                        DisplayAndMessages.deco(DisplayAndMessages.invalidOptionAndRepeat(), red, star);
                        Toolkit.getDefaultToolkit().beep();//Sound for the error
                        counter +=1;//Add 1 to counter to set if a display must be done or not
                }
            } while(!exit);
        }
        return choice;
    }
}

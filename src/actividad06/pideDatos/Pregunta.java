/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad06.pideDatos;
import static actividad06.pideDatos.DisplayAndMessages.messageIoExcp;
import static actividad06.pideDatos.DisplayAndMessages.numErrorMessage;
import static actividad06.GestionVehiculos.br;
import static actividad06.GestionVehiculos.red;
import static actividad06.GestionVehiculos.star;
import java.awt.Toolkit;

import java.io.IOException;

/**
 *
 * @author sergionicolaslopezgarcia
 */
public class Pregunta {
    /**
     *Verifies that the input introduced by the user is an integer, if not catch the NumberFormatException or IOException, displays a message, and ask user
     * for another number till the value introduced is an integer number.
     * @return the user's number (integer)
     */
    public static int isNumInt() {
        int num = 0;
        boolean isNum = false;
        
        do {
            try {
                num = Integer.parseInt(br.readLine());
                isNum = true;
            } catch (IOException ex) {
                DisplayAndMessages.deco(messageIoExcp(ex), red, star);
                Toolkit.getDefaultToolkit().beep();//Sound for the error
            } catch (NumberFormatException ex) {
                DisplayAndMessages.deco(numErrorMessage(), red, star);
                Toolkit.getDefaultToolkit().beep();//Sound for the error
            }     
        } while (!isNum);
        return num;
    }
    
    /**
     *Verifies that the input introduced by the user is a double, if not catch the NumberFormatException or IOException, displays a message, and ask user
     * for another number till the value introduced is a double number.
     * @return the user's number (double)
     */
    public static double isNumDouble() {
        double num = 0;
        boolean isNum = false;
        
        do {
            try {
                num = Double.parseDouble(br.readLine());
                isNum = true;
            } catch (IOException ex) {
                DisplayAndMessages.deco(messageIoExcp(ex), red, star);
                Toolkit.getDefaultToolkit().beep();//Sound for the error
            } catch (NumberFormatException ex) {
                DisplayAndMessages.deco(numErrorMessage(), red, star);
                Toolkit.getDefaultToolkit().beep();//Sound for the error
            }     
        } while (!isNum);
        return num;
    }
}

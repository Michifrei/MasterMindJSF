/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindsjf;

import Mastermind.saveInput.SaveIntegerInput;

/**
 *
 * @author daer
 */
public class AiGui {
    public static void main(){
        /*int maxTries = SaveIntegerInput.newInputDialog(null, "Wie viele Versuche", "Versuche", 0, "Keine Zahl", "Error");
        int numColours = SaveIntegerInput.newInputDialog(null, "Wie viele Farben", "Farben", 0, "Keine Zahl", "Error");
        int maxLenght = SaveIntegerInput.newInputDialog(null, "Wie langer Zahlencode", "Zahlencode", 0, "Keine Zahl", "Error");*/
        int maxTries = 1592;
        int numColours = 6;
        int maxLenght = 4;
        
        
        MasterMindGame mmg = new MasterMindGame(maxTries, maxLenght, numColours);
        //mmg.setCode(new int[]{1,1,0,0});
        AI ai = new AI(mmg);
        System.out.println(ai.play());
        
    }
}

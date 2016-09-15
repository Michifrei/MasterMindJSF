/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindsjf;

import Mastermind.saveInput.SaveIntegerInput;
import java.util.Arrays;

/**
 *
 * @author daer
 */
public class AiGui {
    public static void main(){
        /*int maxTries = SaveIntegerInput.newInputDialog(null, "Wie viele Versuche", "Versuche", 0, "Keine Zahl", "Error");
        int numColours = SaveIntegerInput.newInputDialog(null, "Wie viele Farben", "Farben", 0, "Keine Zahl", "Error");
        int maxLenght = SaveIntegerInput.newInputDialog(null, "Wie langer Zahlencode", "Zahlencode", 0, "Keine Zahl", "Error");*/
        int maxTries = 50;
        int numColours = 8;
        int maxLenght = 8;
        
        
        MasterMindGame mmg = new MasterMindGame(maxTries, maxLenght, numColours);
        //mmg.setCode(new int[]{0,1,0,1});
        AI ai = new AI(mmg);
        int[][] tries = ai.play();
        for(int[] trie : tries){
            System.out.println(Arrays.toString(trie));
        }
        System.out.println(mmg.getTries() + " : "+mmg.getMaxTries());
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindsjf;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daer
 */
public class AI {

    MasterMindGame mmg;

    public AI(MasterMindGame mmg) {
        this.mmg = mmg;

    }

    public int[][] play() {
        int[][] output;
        int[][] allGuess = getAllGuess();
        //Get best Algorithm
        //if (mmg.getCodeLength() == 4&& mmg.getNumColor()==6) {
            
            //Play with 5 Guess Algorithm
            FiveGuessAlgorithm fga = new FiveGuessAlgorithm(allGuess,mmg);
            output = fga.play();
            
        /*} else {
            output = new int[0][];
        }
*/
        return output;
    }

    public final int[][] getAllGuess() {
        //get Array Lenght
        int arrayLenght = (int) Math.pow(mmg.getNumColor(), mmg.getCodeLength());
        int[][] allGuest = new int[arrayLenght][mmg.getCodeLength()];
        //for number of possible combinationes
        for (int index1 = 1; index1 < arrayLenght; index1++) {

            //Copy previous Array
            for (int i = 0; i < allGuest[index1 - 1].length; i++) {
                allGuest[index1][i] = allGuest[index1 - 1][i];
            }

            //plus 1
            allGuest[index1][mmg.getCodeLength() - 1] += 1;
            //if not possible number actuell Number = 0, next number = +1
            for (int index2 = mmg.getCodeLength() - 1; index2 >= 0; index2--) {
                if (allGuest[index1][index2] == mmg.getNumColor() && index1 - 1 >= 0) {
                    allGuest[index1][index2] = 0;
                    allGuest[index1][index2 - 1] += 1;
                }

            }

        }
        return allGuest;
    }

}

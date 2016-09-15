/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindsjf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author daer
 */
public class FiveGuessAlgorithm {

    int[][] allGuess;
    String output = "";
    MasterMindGame mmg;
    List<int[]> allGuessList;

    public FiveGuessAlgorithm() {
    }

    public FiveGuessAlgorithm(int[][] allGuess, MasterMindGame mmg) {
        this.allGuess = allGuess;
        this.mmg = mmg;
        allGuessList = new LinkedList<>(Arrays.asList(allGuess));
    }

    public int[][] play() {
        List<int[]> tries = new LinkedList<>();
        
        Random rnd = new Random();
        int[] response;
        int actCodeIndex;
        do {

            actCodeIndex = getBestActIndex();

            //Get new Guess
            int[] actCode = new int[allGuessList.get(actCodeIndex).length];
            for (int ac = 0; ac < allGuessList.get(actCodeIndex).length; ac++) {
                actCode[ac] = allGuessList.get(actCodeIndex)[ac];
            }

            //Try guess
            try {
                response = mmg.Guess(actCode);
            } catch (Exception ex) {
                return new int[0][];
            }

            //Evaluate Guess
            int exactMatches = countValueinArray(response, 2);
            int colourMatches = countValueinArray(response, 1);
            int falseMatches = countValueinArray(response, 0);
            if (exactMatches != 4) {
                allGuessList.remove(actCodeIndex);

            }

            //Delete All not Possible Codes
            deleteNotPossibleCodes(exactMatches, colourMatches, falseMatches, actCode);

            tries.add(actCode);

        } while (!mmg.hasWon() || mmg.getMaxTries() == mmg.getTries());

        return tries.toArray(new int[tries.size()][]);
    }

    public int getBestActIndex() {
        Random rnd = new Random();
        int bestActIndex;
        if (allGuessList.size() == Math.pow(mmg.getNumColor(), mmg.getCodeLength())) {
            bestActIndex = 7;
        } else {
            bestActIndex = rnd.nextInt(allGuessList.size());
        }

        return bestActIndex;
    }

    @Override
    public String toString() {
        return output;
    }

    private int countValueinArray(int[] array, int value) {
        int counter = 0;
        for (int i : array) {
            if (i == value) {
                counter++;
            }
        }
        return counter;
    }

    private void deleteNotPossibleCodes(int exactMatches, int colourMatches, int falseMatches, int[] actCode) {
        if (falseMatches == mmg.getCodeLength()) {
            deleteGuess0Exact0Color(actCode);
        } else if (colourMatches == mmg.getCodeLength()) {
            deleteGuess0ExactAllColor(actCode);
        } else if (exactMatches == mmg.getCodeLength()) {
            deleteGuessAllExact0Color(actCode);
        } else{
            deleteGuessXExactYColor(actCode,colourMatches,exactMatches);
        }
            
    }

    private void deleteGuessWith(int value) {
        Iterator<int[]> iter = allGuessList.iterator();
        while (iter.hasNext()) {
            int[] code = iter.next();
            for (int i : code) {
                if (i == value) {
                    iter.remove();
                    allGuessList.remove(code);
                    break;
                }
            }

        }
    }

    private void deleteGuess0Exact0Color(int[] codeIsNotLike) {
        for (int i = 0; i < codeIsNotLike.length; i++) {
            deleteGuessWith(codeIsNotLike[i]);
        }
    }

    private void deleteGuessAllExact0Color(int[] codeNotToDelete) {
        Iterator<int[]> iter = allGuessList.iterator();
        while (iter.hasNext()) {
            int[] code = iter.next();
            if (!code.equals(codeNotToDelete)) {
                iter.remove();
                allGuessList.remove(code);
            }

        }
    }

    private void deleteGuess0ExactAllColor(int[] codeIsLike) {
        int counter = 0;

        int[] newCodeIsLike = newArray(codeIsLike);

        Iterator<int[]> iter = allGuessList.iterator();
        while (iter.hasNext()) {
            int[] code = iter.next();
            counter = 0;

            newCodeIsLike = newArray(codeIsLike);
            int[] newCode = newArray(code);

            for (int index = 0; index < newCodeIsLike.length; index++) {
                if (newCode[index] == newCodeIsLike[index]) {
                    newCode[index] = -1;
                    newCodeIsLike[index] = -1;
                }
            }

            for (int indexCode = 0; indexCode < newCode.length; indexCode++) {
                for (int indexCodeIsLike = 0; indexCodeIsLike < newCode.length; indexCodeIsLike++) {
                    if (newCode[indexCode] != -1 && newCode[indexCode] == newCodeIsLike[indexCodeIsLike]) {
                        newCodeIsLike[indexCodeIsLike] = -1;
                        counter++;
                        break;
                    }
                }
            }

            if (counter != mmg.getCodeLength()) {
                iter.remove();
                allGuessList.remove(code);
            }

        }

    }

    private void deleteGuessXExactYColor(int[] codeIsLike,int colourMatches,int exactMatches) {
        int counter = 0;
        int counterExact = 0;

        int[] newCodeIsLike;

        Iterator<int[]> iter = allGuessList.iterator();
        while (iter.hasNext()) {
            int[] code = iter.next();
            counter = 0;
            counterExact = 0;

            newCodeIsLike = newArray(codeIsLike);
            int[] newCode = newArray(code);


            for (int index = 0; index < newCodeIsLike.length; index++) {
                if (newCode[index] == newCodeIsLike[index]) {
                    newCode[index] = -1;
                    newCodeIsLike[index] = -1;
                    counterExact++;
                }
            }

            for (int indexCodeIsLike = 0; indexCodeIsLike < codeIsLike.length; indexCodeIsLike++) {
                for (int indexCode = 0; indexCode < code.length; indexCode++) {
                    if (newCode[indexCode] != -1 && newCodeIsLike[indexCodeIsLike] == newCode[indexCode]) {
                        newCode[indexCode] = -1;
                        newCodeIsLike[indexCodeIsLike] = -1;
                        counter++;
                        break;
                    }
                }
            }

            if (counter != colourMatches||counterExact!=exactMatches) {
                iter.remove();
                allGuessList.remove(code);
            }

        }
    }

    private int[] newArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

}

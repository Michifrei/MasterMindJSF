/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindsjf;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author daer
 */
public class MasterMindGame {

    private int maxTries;
    private int codeLength;
    private int numColor;
    private int[] code;
    private int tries;
    private boolean gameEnd;

    public MasterMindGame(int maxTries, int codeLength, int numColor) {
        this.maxTries = maxTries;
        this.codeLength = codeLength;
        this.numColor = numColor;
        code = createCode();

    }

    public int[] Guess(int guess[]) {
        int[] output = new int[codeLength];
        checkGuessInput(guess);
        int exactMatches = getExactMatches(guess);
        int colourMatches = getColourMatches(guess);
        int falseMatches = getFalseMatches(guess);

        return getMatchesIntArray(exactMatches, colourMatches, falseMatches);
    }

    public boolean hasWon() {
        return gameEnd;
    }

    public int getTries() {
        return tries;
    }

    //create a new Code
    private int[] createCode() {
        Random rnd = new Random();
        int[] code = new int[codeLength];
        for (int i = 0; i < code.length; i++) {
            code[i] = rnd.nextInt(numColor);
        }
        return code;
    }

    //Check is Input Correct
    private void checkGuessInput(int guess[]) {
        if (guess.length != codeLength) {
            throw new NullPointerException();
        }
        for (int g : guess) {
            if (g < 0 || g >= numColor) {
                throw new NullPointerException();
            }
        }
    }

    //Get number of Exact Matches
    private int getExactMatches(int[] guess) {
        int exactMatches = 0;
        for (int index = 0; index < guess.length; index++) {
            if (guess[index] == code[index]) {
                exactMatches++;
            }
        }
        return exactMatches;
    }

    //Get Number of ColourMatches
    private int getColourMatches(int[] guess) {
        int[] code = this.code;
        int colourMatches = 0;
        //Set all ExactMatches -1
        for (int index = 0; index < guess.length; index++) {
            if (guess[index] == code[index]) {
                guess[index] = -1;
                code[index] = -1;

            }
        }
        //Count ColoutMatches
        for (int indexcode = 0; indexcode < code.length; indexcode++) {
            if (code[indexcode] != -1) {
                for (int indexguess = 0; indexguess < guess.length; indexguess++) {
                    if (code[indexcode] == guess[indexcode]) {
                        guess[indexcode] = -1;
                        colourMatches++;
                    }
                }
            }
        }
        return colourMatches;
    }

    //get number of False Matches
    private int getFalseMatches(int[] guess) {
        return codeLength - getColourMatches(guess) - getExactMatches(guess);
    }

    //Create Array with ExactMatches, ColourMatches, FalseMatches
    private int[] getMatchesIntArray(int exactMatches, int colourMatches, int falseMatches) {
        int arrayLength = exactMatches + colourMatches + falseMatches;
        int[] out = new int[arrayLength];
        Arrays.fill(out, 1);
        for (int index = 0; index < out.length; index++) {
            if (index < falseMatches) {
                out[index] = 0;
            }
            if (index >= arrayLength-exactMatches) {
                out[index] = 2;
            }
        }
        return out;
    }
}

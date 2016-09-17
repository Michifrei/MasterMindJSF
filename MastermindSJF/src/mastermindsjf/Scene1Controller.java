/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindsjf;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Lukas
 */
public class Scene1Controller //implements Initializable 
{

    ObservableList<String> codeLengthChoices = FXCollections.observableArrayList("4", "6");
    ObservableList<String> numberOfTriesChoices = FXCollections.observableArrayList("12");
    ObservableList<String> numberOfColorsChoices = FXCollections.observableArrayList("2", "4", "6");
    
    int codeLength = 4;
    int numberOfTries = 12;
    int numberOfColors = 6;
    
    int maxCodeLength = 6;
    int maxTries = 12;
    int maxNumberOfColors = 6;

    public String[][] dotIdArray;// = getIdArray("dot");
    public String[][] pinIdArray;// = getIdArray("pin");
    public String[] guessDots = {"guessDot1", "guessDot2", "guessDot3", "guessDot4", "guessDot5", "guessDot6"};
    public String[] guessButtons = {"blueButton", "greenButton", "yellowButton", "redButton", "purpleButton", "orangeButton"};
    public String[] codeDots = {"codeDot1", "codeDot2", "codeDot3", "codeDot4", "codeDot5", "codeDot6"};

    public ObservableList rowList;

    public ObservableList dotList;

    public Scene scene;

    public Circle currentDot;
    public MasterMindGame mmg;

    String grey = "#bfbfbf";
    int turn = 1;

    ArrayList<String> dotColorList = new ArrayList<String>() {
        {
            add("blue");
            add("green");
            add("yellow");
            add("red");
            add("purple");
            add("orange");
        }
    };
    ArrayList<String> dotHexColorList = new ArrayList<String>() {
        {
            add("0x0000ffff");
            add("0x00ff00ff");
            add("0xffff00ff");
            add("0xff0000ff");
            add("0xbf00bfff");
            add("0xff7f00ff");
        }
    };
    ArrayList<String> pinColorList = new ArrayList<String>() {
        {
            add("empty");
            add("white");
            add("black");
        }
    };
    ArrayList<String> pinHexColorList = new ArrayList<String>() {
        {
            add("0x00000000");
            add("0xffffffff");
            add("0x000000ff");
        }
    };

    @FXML
    private Circle dotL1;
    @FXML
    private Color x1;
    @FXML
    private Insets x6;
    @FXML
    private Circle dotL2;
    @FXML
    private Circle dotL3;
    @FXML
    private Circle dotL4;
    @FXML
    private Circle dotK1;
    @FXML
    private Circle dotK2;
    @FXML
    private Circle dotK3;
    @FXML
    private Circle dotK4;
    @FXML
    private Circle dotJ1;
    @FXML
    private Circle dotJ2;
    @FXML
    private Circle dotJ3;
    @FXML
    private Circle dotJ4;
    @FXML
    private Circle dotI1;
    @FXML
    private Circle dotI2;
    @FXML
    private Circle dotI3;
    @FXML
    private Circle dotI4;
    @FXML
    private Circle dotH1;
    @FXML
    private Circle dotH2;
    @FXML
    private Circle dotH3;
    @FXML
    private Circle dotH4;
    @FXML
    private Circle dotG1;
    @FXML
    private Circle dotG2;
    @FXML
    private Circle dotG3;
    @FXML
    private Circle dotG4;
    @FXML
    private Circle dotF1;
    @FXML
    private Circle dotF2;
    @FXML
    private Circle dotF3;
    @FXML
    private Circle dotF4;
    @FXML
    private Circle dotE1;
    @FXML
    private Circle dotE2;
    @FXML
    private Circle dotE3;
    @FXML
    private Circle dotE4;
    @FXML
    private Circle dotD1;
    @FXML
    private Circle dotD2;
    @FXML
    private Circle dotD3;
    @FXML
    private Circle dotD4;
    @FXML
    private Circle dotC1;
    @FXML
    private Circle dotC2;
    @FXML
    private Circle dotC3;
    @FXML
    private Circle dotC4;
    @FXML
    private Circle dotB1;
    @FXML
    private Circle dotB2;
    @FXML
    private Circle dotB3;
    @FXML
    private Circle dotB4;
    @FXML
    private Circle dotA1;
    @FXML
    private Circle dotA2;
    @FXML
    private Circle dotA3;
    @FXML
    private Circle dotA4;
    @FXML
    private Insets x4;
    @FXML
    private Circle pinL1;
    @FXML
    private Insets x8;
    @FXML
    private Circle pinL2;
    @FXML
    private Circle pinL3;
    @FXML
    private Circle pinL4;
    @FXML
    private Circle pinK1;
    @FXML
    private Circle pinK2;
    @FXML
    private Circle pinK3;
    @FXML
    private Circle pinK4;
    @FXML
    private Circle pinJ1;
    @FXML
    private Circle pinJ2;
    @FXML
    private Circle pinJ3;
    @FXML
    private Circle pinJ4;
    @FXML
    private Circle pini1;
    @FXML
    private Circle pinI2;
    @FXML
    private Circle pinI3;
    @FXML
    private Circle pinI4;
    @FXML
    private Circle pinH1;
    @FXML
    private Circle pinH2;
    @FXML
    private Circle pinH3;
    @FXML
    private Circle pinH4;
    @FXML
    private Circle pinG1;
    @FXML
    private Circle pinG2;
    @FXML
    private Circle pinG3;
    @FXML
    private Circle pinG4;
    @FXML
    private Circle pinF1;
    @FXML
    private Circle pinF2;
    @FXML
    private Circle pinF3;
    @FXML
    private Circle pinF4;
    @FXML
    private Circle pinE1;
    @FXML
    private Circle pinE2;
    @FXML
    private Circle pinE3;
    @FXML
    private Circle pinE4;
    @FXML
    private Circle pinD1;
    @FXML
    private Circle pinD2;
    @FXML
    private Circle pinD3;
    @FXML
    private Circle pinD4;
    @FXML
    private Circle pinC1;
    @FXML
    private Circle pinC2;
    @FXML
    private Circle pinC3;
    @FXML
    private Circle pinC4;
    @FXML
    private Circle pinB1;
    @FXML
    private Circle pinB2;
    @FXML
    private Circle pinB3;
    @FXML
    private Circle pinB4;
    @FXML
    private Circle pinA1;
    @FXML
    private Circle pinA2;
    @FXML
    private Circle pinA3;
    @FXML
    private Circle pinA4;
    @FXML
    private Button giveUpButton;
    @FXML
    private Font x5;
    @FXML
    private Button guessButton;
    @FXML
    private Button blueButton;
    @FXML
    private Insets x3;
    @FXML
    private Button greenButon;
    @FXML
    private Button yellowButton;
    @FXML
    private Button redButton;
    @FXML
    private Button PurpleButton;
    @FXML
    private Button orangeButton;
    @FXML
    private Circle guessDot1;
    @FXML
    private Circle guessDot2;
    @FXML
    private Circle guessDot3;
    @FXML
    private Circle guessDot4;
    @FXML
    private Circle codeDot1;
    @FXML
    private Circle codeDot2;
    @FXML
    private Circle codeDot4;
    @FXML
    private Button newGameButton;
    @FXML
    private Font x7;
    @FXML
    private Button AIButton;
    @FXML
    private Button ManualButton;
    @FXML
    private TitledPane newGameWindow;
    @FXML
    private Insets x2;
    @FXML
    private ChoiceBox codeLengthBox;
    @FXML
    private ChoiceBox numberOfColorsBox;
    @FXML
    private ChoiceBox numberOfTriesBox;
    @FXML
    private Button StartGameCancleButton;
    private ProgressIndicator startGameLoadingWheel;
    @FXML
    private Text startGameErrorTextField;
    @FXML
    private GridPane playField;
    @FXML
    private Circle codeDot3;
    @FXML
    private TitledPane gameOverWindow;
    @FXML
    private Text gameOverText;
    @FXML
    private Button gameOverOkButton;
    @FXML
    private Button gameOverNewGameButton;
    @FXML
    private Font x9;
    @FXML
    private TitledPane manualWindow;
    @FXML
    private Color x10;
    @FXML
    private Circle guessDot5;
    @FXML
    private Circle guessDot6;
    @FXML
    private TitledPane aiPlayerWindow;
    @FXML
    private ChoiceBox<?> aiCodeLengthCheckBox;
    @FXML
    private ChoiceBox<?> aiNumberOfColorsCheckBox;
    @FXML
    private ChoiceBox<?> aiNumberOfTriesCheckBox;
    @FXML
    private Button aiCancelButton;
    @FXML
    private Button aiDiagnoseButton;
    @FXML
    private Button aiSolveButton;

    /**
     * Initializes the controller class.
     */
    /*
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    */
    public void initialize() {

        numberOfTriesBox.setValue("12");
        numberOfTriesBox.setItems(numberOfTriesChoices);

        codeLengthBox.setValue("4");
        codeLengthBox.setItems(codeLengthChoices);

        numberOfColorsBox.setValue("6");
        numberOfColorsBox.setItems(numberOfColorsChoices);
    }

    @FXML
    private void giveUp(ActionEvent event) {
        endGame(mmg);
    }

    @FXML
    private void guess(ActionEvent event) {

        List<String> guessDotIdList = new ArrayList<String>();
        int[] guessArray = new int[codeLength];
        int[] answerArray = null;
        
        for(int i=0; i<codeLength; i++)
        {
            guessDotIdList.add("#"+guessDots[i]);
            Circle guessDotObj = (Circle) scene.lookup(guessDotIdList.get(i));
            int number = dotHexColorList.indexOf(guessDotObj.fillProperty().getValue().toString());
            guessArray[i] = number;
        }

        // Checks if every button has a color. If not, abort.
        for (int i = 0; i < codeLength; i++) {
            if (guessArray[i] == -1) {
                return;
            }
        }

        // Set the selected guess on the board...
        for (int i = 0; i < codeLength; i++) {
            //Circle dot = (Circle) scene.lookup("#"+dotIdArray[turn-1][i]);
            //System.out.println(dotIdArray[turn - 1][i - 1]);
            Circle dot = (Circle) scene.lookup(dotIdArray[turn - 1][i]);
            Circle guessButton = (Circle) scene.lookup("#guessDot" + (i+1));
            dot.setFill(guessButton.getFill());
        }

        // Ask for an answer...
        try {
            answerArray = mmg.Guess(guessArray);
        } catch (Exception ex) {
            Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Check if won..
        if (Arrays.equals(guessArray, mmg.getCode())) {
            //System.out.println("You have guessed the ansewer!");
            endGame(mmg);

        }

        setAnswer(answerArray);
        nextTurn(); // proceed to next turn
    }

    @FXML
    private void bluePressed(ActionEvent event) {
        if (currentDot != null) {
            currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("blue"))));
            removeCurrentDot();
        }
    }

    @FXML
    private void greenPressed(ActionEvent event) {
        if (currentDot != null) {
            currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("green"))));
            removeCurrentDot();
        }
    }

    @FXML
    private void yellowPressed(ActionEvent event) {
        if (currentDot != null) {
            currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("yellow"))));
            removeCurrentDot();
        }
    }

    @FXML
    private void redPressed(ActionEvent event) {
        if (currentDot != null) {
            currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("red"))));
            removeCurrentDot();
        }
    }

    @FXML
    private void purplePressed(ActionEvent event) {
        if (currentDot != null) {
            currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("purple"))));
            removeCurrentDot();
        }
    }

    @FXML
    private void orangePressed(ActionEvent event) {
        if (currentDot != null) {
            currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("orange"))));
            removeCurrentDot();
        }
    }

    @FXML
    private void newGame(ActionEvent event) {
        enableAndVisible(newGameWindow);
    }

    @FXML
    private void cancleStartGame(ActionEvent event) {
        disableAndInvisible(newGameWindow);
    }

    @FXML
    private void startGame(ActionEvent event) {

        

        scene = dotA1.getScene();

        numberOfTries = Integer.parseInt(numberOfTriesChoices.get(numberOfTriesBox.getSelectionModel().getSelectedIndex()));
        codeLength = Integer.parseInt(codeLengthChoices.get(codeLengthBox.getSelectionModel().getSelectedIndex()));
        numberOfColors = Integer.parseInt(numberOfColorsChoices.get(numberOfColorsBox.getSelectionModel().getSelectedIndex()));;
        
        dotIdArray = getIdArray("dot");
        pinIdArray = getIdArray("pin");
        
        resetPlayField(scene);
        
        
        playField.setDisable(false);

        mmg = new MasterMindGame(numberOfTries, codeLength, numberOfColors);
        //System.out.println("Requested game with " + maxTries + " tries, a " + codeLength + " digit code and " + mmg.getNumColor() + " colors.");

        disableAndInvisible(newGameWindow);

    }

    @FXML
    private void guessDotClicked(MouseEvent event) {
        Circle dot = (Circle) scene.lookup(getGuessDotIdFromMouseEvent(event));
        dot.setStrokeWidth(2);

        setCurrentDot(dot);
    }

    public void setCurrentDot(Circle dot) {
        currentDot = dot;
        currentDot.setStrokeWidth(2);

        for (int i = 0; i < codeLength; i++) {
            //System.out.println(currentDot.getId().toString() + " != " + guessDots[i].toString());
            Circle otherDot = (Circle) scene.lookup("#" + guessDots[i]);

            if (currentDot.getId().toString().equalsIgnoreCase(guessDots[i].toString()) != true) {

                otherDot.setStrokeWidth(0);
            }
        }
    }

    public void removeCurrentDot() {
        currentDot = null;

        for (int i = 0; i < codeLength; i++) {
            Circle otherDot = (Circle) scene.lookup("#" + guessDots[i]);
            otherDot.setStrokeWidth(0);
        }
    }

    public void setAnswer(int[] answerArray) {
        //System.out.println("Trying to save the answer");
        for (int i = 0; i < codeLength; i++) {
            //Circle dot = (Circle) scene.lookup("#"+dotIdArray[turn-1][i]);
            Circle pin = (Circle) scene.lookup(pinIdArray[turn - 1][i]);
            pin.setFill(Paint.valueOf(pinHexColorList.get(answerArray[i])));
        }

    }

    public void nextTurn() {
        
        List<String> guessDotIdList = new ArrayList<String>();
        
        for(int i=0; i<codeLength; i++)
        {
            guessDotIdList.add("#"+guessDots[i]);
            Circle guessDotObj = (Circle) scene.lookup(guessDotIdList.get(i));
            guessDotObj.setFill(Paint.valueOf(grey));
        }

        if (turn < numberOfTries) {
            turn++;
        } else {
            endGame(mmg);
        }

    }

    public void endGame(MasterMindGame currentGame) {
        // Stop the player from playing
        playField.setDisable(true);
        mmg = null;

        // show code
        int[] code = currentGame.getCode();
        int triesUsed = currentGame.getTries();
        
        List<String> codeDotIdList = new ArrayList<String>();
        
        for(int i=0; i<codeLength; i++)
        {
            codeDotIdList.add("#"+codeDots[i]);
            Circle codeDotObj = (Circle) scene.lookup(codeDotIdList.get(i));
            codeDotObj.setFill(Paint.valueOf(dotHexColorList.get(code[i])));
        }

        //System.out.println("Game has ended");
        // Show message...
        if (currentGame.hasWon()) {
            //System.out.println("Player has won! in " + triesUsed);
            showWonMessage(triesUsed);
        } else {
            //System.out.println("Player has lost...");
            showLostMessage();
        }
    }

    public void endAiGame(MasterMindGame game) {
        // show code
        int[] code = game.getCode();
        int triesUsed = game.getTries();

        List<String> codeDotIdList = new ArrayList<String>();
        
        for(int i=0; i<codeLength; i++)
        {
            codeDotIdList.add("#"+codeDots[i]);
            Circle codeDotObj = (Circle) scene.lookup(codeDotIdList.get(i));
            codeDotObj.setFill(Paint.valueOf(dotHexColorList.get(code[i])));
        }

        //System.out.println("Game has ended");
        // Show message...
        if (game.hasWon()) {
            //System.out.println("The AI beat the game in " + triesUsed + " turns!");
        } else {
            //System.out.println("But.. But the AI can't lose!");
        }
    }

    public void showWonMessage(int tries) {
        gameOverText.setText("You Won in " + tries + " turns!");
        enableAndVisible(gameOverWindow);
    }

    public void showLostMessage() {
        gameOverText.setText("You Lost!");
        enableAndVisible(gameOverWindow);
    }

    public void enableAndVisible(Node obj) {
        obj.setDisable(false);
        obj.setVisible(true);
    }

    public void disableAndInvisible(Node obj) {
        obj.setDisable(true);
        obj.setVisible(false);
    }

    public String[][] getIdArray(String prefix) {
        String[] idLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};

        String[][] rowArray = new String[maxTries][maxCodeLength];
        String currentIdString;

        for (int i = 0; i < maxTries; i++) {
            for (int j = 1; j <= maxCodeLength; j++) {
                currentIdString = "#" + prefix + idLetters[i] + Integer.toString(j);

                //System.out.println("rowArray["+i+"]["+j+"] = "+currentIdString);
                rowArray[i][j-1] = currentIdString;
            }
        }

        return rowArray;
    }

    @FXML
    private void okGameOver(ActionEvent event) {
        disableAndInvisible(gameOverWindow);
    }

    @FXML
    private void gameOverNewGame(ActionEvent event) {
        disableAndInvisible(gameOverWindow);
        startGame(event);
    }

    public void resetPlayField(Scene scene) {
        turn = 1;
        
        

        // Reset the dots and pins
        for (int i = 0; i < maxTries; i++) {
            for (int j = 0; j < maxCodeLength; j++) {
                //System.out.println("dot = "+dotIdArray[i][j]);
                Circle dot = (Circle) scene.lookup(dotIdArray[i][j]);
                Circle pin = (Circle) scene.lookup(pinIdArray[i][j]);

                dot.setFill(Paint.valueOf(grey));
                //System.out.println("dotId = "+dotIdArray[i][j]);
                //System.out.println("pinId = "+pinIdArray[i][j]);
                pin.setFill(Paint.valueOf(grey));
            }
        }
        
        // enable all buttons
        for(int i = 0; i<maxNumberOfColors; i++)
        {
            Button button = (Button) scene.lookup("#"+guessButtons[i]); 
            //System.out.println("button = "+guessButtons[i]);
            button.setDisable(false);
            //disableAndInvisible(button);
        }
        
        //disable all unusable Buttons
        for(int i = maxNumberOfColors; i>numberOfColors; i--)
        {
            Button button = (Button) scene.lookup("#"+guessButtons[i-1]); 
            button.setDisable(true);
            //disableAndInvisible(button);
        }
        
        
        // enable all dots
        for(int v=0; v<maxTries; v++)
        {
            for(int i = 0; i<maxCodeLength; i++)
            {
                Circle dot = (Circle) scene.lookup(dotIdArray[v][i]); 
                enableAndVisible(dot);
            }
        }
        
        //disable all unusable dots
        for(int v=0; v<maxTries; v++)
        {
            for(int i = maxCodeLength; i>codeLength; i--)
            {
                Circle dot = (Circle) scene.lookup(dotIdArray[v][i-1]); 
                disableAndInvisible(dot);
            }
        }
        
        // enable all pins
        for(int v=0; v<maxTries; v++)
        {
            for(int i = 0; i<maxCodeLength; i++)
            {
                Circle pin = (Circle) scene.lookup(pinIdArray[v][i]); 
                enableAndVisible(pin);
            }
        }
        //disable all unusable pins
        for(int v=0; v<maxTries; v++)
        {
            for(int i = maxCodeLength; i>codeLength; i--)
            {
                Circle pin = (Circle) scene.lookup(pinIdArray[v][i-1]); 
                disableAndInvisible(pin);
            }
        }

        // Reset the code
        List<String> codeDotIdList = new ArrayList<String>();
        
        for(int i=0; i<codeLength; i++)
        {
            codeDotIdList.add("#"+codeDots[i]);
            Circle codeDotObj = (Circle) scene.lookup(codeDotIdList.get(i));
            codeDotObj.setFill(Paint.valueOf(grey));
        }
        
        // enable all codeDots
        for(int i = 0; i<maxCodeLength; i++)
        {
            Circle dot = (Circle) scene.lookup("#"+codeDots[i]); 
            enableAndVisible(dot);
        }
        //disable all unusable codeDots
        for(int i = maxCodeLength; i>codeLength; i--)
        {
            Circle dot = (Circle) scene.lookup("#"+codeDots[i-1]); 
            disableAndInvisible(dot);
        }
    
    // enable all guessDots
        for(int i = 0; i<maxCodeLength; i++)
        {
            Circle dot = (Circle) scene.lookup("#"+guessDots[i]); 
            enableAndVisible(dot);
        }
        //disable all unusable codeDots
        for(int i = maxCodeLength; i>codeLength; i--)
        {
            Circle dot = (Circle) scene.lookup("#"+guessDots[i-1]); 
            disableAndInvisible(dot);
        }
    
    }

    @FXML
    private void guessDotExited(MouseEvent event) {
        Circle dot = (Circle) scene.lookup(getGuessDotIdFromMouseEvent(event));
        if (currentDot != dot) {
            dot.setStrokeWidth(0);
        }

    }

    @FXML
    private void guessDotEntered(MouseEvent event) {
        //System.out.println(getGuessDotIdFromMouseEvent(event));
        Circle dot = (Circle) scene.lookup(getGuessDotIdFromMouseEvent(event));
        dot.setStrokeWidth(1);
    }

    public String getGuessDotIdFromMouseEvent(MouseEvent event) {
        return "#" + event.getSource().toString().substring(10, 19);
    }

    @FXML
    private void AIPlayer(ActionEvent event) 
    {
        enableAndVisible(aiPlayerWindow);
    }

    @FXML
    private void openManual(ActionEvent event) {
        enableAndVisible(manualWindow);
    }

    @FXML
    private void okManual(ActionEvent event) {
        disableAndInvisible(manualWindow);
    }

    //Get number of Exact Matches
    private int getExactMatches(int[] guess, int[] code) {
        int exactMatches = 0;
        for (int index = 0; index < guess.length; index++) {
            if (guess[index] == code[index]) {
                exactMatches++;
            }
        }
        return exactMatches;
    }

//Get Number of ColourMatches
    private int getColourMatches(int[] guess, int[] code) {

        int[] newcode = new int[code.length];
        int[] newguess = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            newcode[i] = code[i];
            newguess[i] = guess[i];
        }

        int colourMatches = 0;
        //Set all ExactMatches -1
        for (int index = 0; index < newguess.length; index++) {
            if (newguess[index] == newcode[index]) {
                newguess[index] = -1;
                newcode[index] = -1;

            }
        }
        //Count ColourMatches
        for (int indexcode = 0; indexcode < newcode.length; indexcode++) {
            for (int indexguess = 0; indexguess < newguess.length; indexguess++) {
                if (newcode[indexcode] == newguess[indexguess] && newguess[indexguess] != -1 && newcode[indexcode] != -1) {
                    newguess[indexguess] = -1;
                    newcode[indexcode] = -1;
                    colourMatches++;
                }
            }
        }
        return colourMatches;
    }

    //get number of False Matches
    private int getFalseMatches(int[] guess, int[] code) {
        return guess.length - getColourMatches(guess, code) - getExactMatches(guess, code);
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
            if (index >= arrayLength - exactMatches) {
                out[index] = 2;
            }
        }
        return out;
    }

    @FXML
    private void aiCancleStartGame(ActionEvent event) 
    {
        disableAndInvisible(aiPlayerWindow);
    }

    @FXML
    private void aiDiagnose(ActionEvent event) {
    }

    @FXML
    private void aiStartGame(ActionEvent event) 
    {
        disableAndInvisible(aiPlayerWindow);
        
        if(mmg != null)
        {
            endGame(mmg);
        }
        
        
        numberOfTries = Integer.parseInt(numberOfTriesChoices.get(numberOfTriesBox.getSelectionModel().getSelectedIndex()));
        codeLength = Integer.parseInt(codeLengthChoices.get(codeLengthBox.getSelectionModel().getSelectedIndex()));
        numberOfColors = Integer.parseInt(numberOfColorsChoices.get(numberOfColorsBox.getSelectionModel().getSelectedIndex()));
        
        dotIdArray = getIdArray("dot");
        pinIdArray = getIdArray("pin");
        
        scene = dotA1.getScene();
        resetPlayField(scene);
        
        MasterMindGame aig = new MasterMindGame(numberOfTries, codeLength, numberOfColors);
        AI aip = new AI(aig);
        //aip.setSpeedMode(false);

        int[][] aiGuesses = aip.play();

        int[] pinAnswerArray = aiGuesses[aiGuesses.length - 1];

        for (int v = 0; v < aiGuesses.length; v++) {
            for (int i = 0; i < codeLength; i++) {
                //System.out.println("id = " + dotIdArray[v][i]);
                Circle fillDot = (Circle) scene.lookup(dotIdArray[v][i]);
                fillDot.setFill(Paint.valueOf(dotHexColorList.get(aiGuesses[v][i])));
            }

            int exactMatches = getExactMatches(aiGuesses[v], pinAnswerArray);
            int colorMatches = getColourMatches(aiGuesses[v], pinAnswerArray);
            int flaseMatches = getFalseMatches(aiGuesses[v], pinAnswerArray);
            int[] pinAnswer = getMatchesIntArray(exactMatches, colorMatches, flaseMatches);

            for (int i = 0; i < codeLength; i++) {
                //System.out.println("id = " + pinIdArray[v][i]);
                Circle fillDot = (Circle) scene.lookup(pinIdArray[v][i]);
                fillDot.setFill(Paint.valueOf(pinHexColorList.get(pinAnswer[i])));
            }
        }

        endAiGame(aig);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindsjf;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
    ObservableList<String> numberOfTriesChoices = FXCollections.observableArrayList("8", "10", "12");
    ObservableList<String> numberOfColorsChoices = FXCollections.observableArrayList("2", "4", "6");
    
    public String[][] dotIdArray = getIdArray("dot");
    public String[][] pinIdArray = getIdArray("pin");
    public String[] guessButtons = {"guessDot1", "guessDot2", "guessDot3", "guessDot4"};
    
    public ObservableList rowList;
    
    public ObservableList dotList;
    
    public Scene scene;
    
    public Circle currentDot;
    public MasterMindGame mmg;
    
    String grey = "#bfbfbf";
    int turn = 1;
    
    ArrayList<String> dotColorList = new ArrayList<String>() 
    {{
        add("blue"); 
        add("green"); 
        add("yellow"); 
        add("red"); 
        add("purple"); 
        add("orange");
    }};
    ArrayList<String> dotHexColorList = new ArrayList<String>()
    {{
        add("0x0000ffff"); 
        add("0x00ff00ff"); 
        add("0xffff00ff"); 
        add("0xff0000ff"); 
        add("0xbf00bfff"); 
        add("0xff7f00ff");
    }};
    ArrayList<String> pinColorList = new ArrayList<String>() 
    {{
        add("empty");
        add("white"); 
        add("black"); 
    }};
    ArrayList<String> pinHexColorList = new ArrayList<String>()
    {{
        add("0x00000000");
        add("0xffffffff"); 
        add("0x000000ff"); 
    }};
    
    
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

    /**
     * Initializes the controller class.
     */
    /*
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    */
    
    public void initialize()
    {
        
               
        numberOfTriesBox.setValue("12");
        numberOfTriesBox.setItems(numberOfTriesChoices);
        
        codeLengthBox.setValue("4");
        codeLengthBox.setItems(codeLengthChoices);
        
        numberOfColorsBox.setValue("6");
        numberOfColorsBox.setItems(numberOfColorsChoices);
    }

    @FXML
    private void giveUp(ActionEvent event) 
    {
        endGame();
    }

    @FXML
    private void guess(ActionEvent event) 
    {        
        
        
        int firstNumber = dotHexColorList.indexOf(guessDot1.fillProperty().getValue().toString());
        int secondNumber = dotHexColorList.indexOf(guessDot2.fillProperty().getValue().toString());
        int thirdNumber = dotHexColorList.indexOf(guessDot3.fillProperty().getValue().toString());
        int fourthNumber = dotHexColorList.indexOf(guessDot4.fillProperty().getValue().toString());
        
        int[] guessArray = new int[]{firstNumber, secondNumber, thirdNumber, fourthNumber};
        int[] answerArray = null;
        
        for(int i=0; i<4; i++)
        {
            if(guessArray[i] == -1)
            {
                return;
            }    
        }
        
        
        // Set the selected guess on the board...
        
        for(int i=1; i<=mmg.getCodeLength(); i++)
        {
            //Circle dot = (Circle) scene.lookup("#"+dotIdArray[turn-1][i]);
            System.out.println(dotIdArray[turn-1][i-1]);
            Circle dot = (Circle) scene.lookup(dotIdArray[turn-1][i-1]);
            Circle guessButton = (Circle) scene.lookup("#guessDot"+i);
            dot.setFill(guessButton.getFill());
        }
        
        // Ask for an answer...
        try {
            answerArray = mmg.Guess(guessArray);
        } catch (Exception ex) {
            Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Check if won..
        if(Arrays.equals(guessArray, mmg.getCode()))
        {
            System.out.println("You have guessed the ansewer!");
            endGame();
        }
        
        setAnswer(answerArray);
        nextTurn(); // proceed to next turn
    }

    @FXML
    private void bluePressed(ActionEvent event) 
    {
        if(currentDot != null)
        {
            currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("blue"))));
            removeCurrentDot();
        }
    }

    @FXML
    private void greenPressed(ActionEvent event) 
    {
        if(currentDot != null)
        {
            currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("green"))));
            removeCurrentDot();
        }
    }

    @FXML
    private void yellowPressed(ActionEvent event) 
    {
        if(currentDot != null)
        {
            currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("yellow"))));
            removeCurrentDot();
        }
    }

    @FXML
    private void redPressed(ActionEvent event) 
    {
        if(currentDot != null)
        {    
            currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("red"))));
            removeCurrentDot();
        }
    }

    @FXML
    private void purplePressed(ActionEvent event) 
    {
        if(currentDot != null)
        {
            currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("purple"))));
            removeCurrentDot();
        }
    }

    @FXML
    private void orangePressed(ActionEvent event) 
    {
        if(currentDot != null)
        {
            currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("orange"))));
            removeCurrentDot();
        }
    }

    @FXML
    private void newGame(ActionEvent event) 
    {
        enableAndVisible(newGameWindow);
    }



    @FXML
    private void cancleStartGame(ActionEvent event) 
    {
        disableAndInvisible(newGameWindow);
    }

    @FXML
    private void startGame(ActionEvent event) 
    {
        
                
        int maxTries = Integer.parseInt(numberOfTriesChoices.get(numberOfTriesBox.getSelectionModel().getSelectedIndex()));
        int codeLength = Integer.parseInt(codeLengthChoices.get(codeLengthBox.getSelectionModel().getSelectedIndex()));
        int numberOfColors = Integer.parseInt(numberOfColorsChoices.get(numberOfColorsBox.getSelectionModel().getSelectedIndex()));;
        
        if(maxTries != 12 || codeLength != 4 || numberOfColors != 6)
        {
            String errorString = "Some values are not supported yet!";
            startGameErrorTextField.setText(errorString);
            startGameErrorTextField.setVisible(true);
            return;
        }
        
        scene = dotA1.getScene();
        
        resetPlayField(maxTries, codeLength, scene);
        
        playField.setDisable(false);
        
        mmg = new MasterMindGame(maxTries, codeLength, numberOfColors);
        System.out.println("Requested game with "+maxTries+" tries, a "+codeLength+" digit code and "+mmg.getNumColor()+" colors.");
        
        newGameWindow.setDisable(true);
        newGameWindow.setVisible(false);
        

    }

    @FXML
    private void guessDotClicked(MouseEvent event) 
    {
        Circle dot = (Circle) scene.lookup(getGuessDotIdFromMouseEvent(event));
        dot.setStrokeWidth(2);
        
        setCurrentDot(dot);
    }
    
    public void setCurrentDot(Circle dot)
    {
        currentDot = dot;
        currentDot.setStrokeWidth(2);
        
        for(int i=0; i<4; i++)
        {
            System.out.println(currentDot.getId().toString()+" != "+guessButtons[i].toString());
            Circle otherDot = (Circle) scene.lookup("#"+guessButtons[i]);
            
            if(currentDot.getId().toString().equalsIgnoreCase(guessButtons[i].toString()) != true)
            {
                
                otherDot.setStrokeWidth(0);
            }
        }
    }
    public void removeCurrentDot()
    {
        currentDot = null;
        
        for(int i=0; i<4; i++)
        {
            Circle otherDot = (Circle) scene.lookup("#"+guessButtons[i]);
            otherDot.setStrokeWidth(0);
        }
    }
    
    public void setAnswer(int[] answerArray)
    {
        //System.out.println("Trying to save the answer");
        for(int i=0; i<mmg.getCodeLength(); i++)
        {
            //Circle dot = (Circle) scene.lookup("#"+dotIdArray[turn-1][i]);
            Circle pin = (Circle) scene.lookup(pinIdArray[turn-1][i]);
            pin.setFill(Paint.valueOf(pinHexColorList.get(answerArray[i])));
        }
        
        
    }
    
    public void nextTurn()
    {
        guessDot1.setFill(Paint.valueOf(grey));
        guessDot2.setFill(Paint.valueOf(grey));
        guessDot3.setFill(Paint.valueOf(grey));
        guessDot4.setFill(Paint.valueOf(grey));

        if(turn<12)
        {
            turn++;
        }
        else
        {
            endGame();
        }
        
    }
    
    public void endGame()
    {
        // Stop the player from playing
        playField.setDisable(true);
        
        // show code
        int[] code = mmg.getCode();
        int triesUsed = mmg.getTries();

        codeDot1.setFill(Paint.valueOf(dotHexColorList.get(code[0])));
        codeDot2.setFill(Paint.valueOf(dotHexColorList.get(code[1])));
        codeDot3.setFill(Paint.valueOf(dotHexColorList.get(code[2])));
        codeDot4.setFill(Paint.valueOf(dotHexColorList.get(code[3])));
        
        System.out.println("Game has ended");
        // Show message...
        if(mmg.hasWon())
        {
            System.out.println("Player has won! in "+triesUsed);
            showWonMessage(triesUsed);
        }
        else
        {
            System.out.println("Player has lost...");
            showLostMessage();
        }
    }
    
    public void showWonMessage(int tries)
    {
        gameOverText.setText("You Won in "+tries+" turns!");
        enableAndVisible(gameOverWindow);
    }
    public void showLostMessage()
    {
        gameOverText.setText("You Lost!");
        enableAndVisible(gameOverWindow);
    }
    public void enableAndVisible(Node obj)
    {
        obj.setDisable(false);
        obj.setVisible(true);
    }
    public void disableAndInvisible(Node obj)
    {
        obj.setDisable(true);
        obj.setVisible(false);
    }
    
    public String[][] getIdArray(String prefix)
     {
         String[] idLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
         
         String[][] rowArray = new String[12][4];
         String currentIdString = "";
         
         for(int i=0; i<idLetters.length; i++)
         {
             for(int j=0; j<4; j++)
             {
                 currentIdString = "#"+prefix+idLetters[i]+Integer.toString(j+1);
                 
                 //System.out.println("rowArray["+i+"]["+j+"] = "+currentIdString);
                 rowArray[i][j] = currentIdString;
             }
         }
         
         return rowArray;
     }

    @FXML
    private void okGameOver(ActionEvent event) 
    {
        disableAndInvisible(gameOverWindow);
    }

    @FXML
    private void gameOverNewGame(ActionEvent event) 
    {
        disableAndInvisible(gameOverWindow);
        startGame(event);
    }
    
    public void resetPlayField(int maxTries, int codeLength, Scene scene)
    {
        turn = 1;
        
        // Reset the dots and pins
        for(int i=0; i<maxTries; i++)
        {
            for(int j=0; j<codeLength; j++)
            {
                Circle dot = (Circle) scene.lookup(dotIdArray[i][j]);
                Circle pin = (Circle) scene.lookup(pinIdArray[i][j]);
                
                dot.setFill(Paint.valueOf(grey));
                pin.setFill(Paint.valueOf(grey));
            }
        }
        
        // Reset the code
        codeDot1.setFill(Paint.valueOf(grey));
        codeDot2.setFill(Paint.valueOf(grey));
        codeDot3.setFill(Paint.valueOf(grey));
        codeDot4.setFill(Paint.valueOf(grey));
    }

    @FXML
    private void guessDotExited(MouseEvent event) 
    {
        Circle dot = (Circle) scene.lookup(getGuessDotIdFromMouseEvent(event));
        if(currentDot != dot)
        {
            dot.setStrokeWidth(0);
        }

    }

    @FXML
    private void guessDotEntered(MouseEvent event) 
    {
        System.out.println(getGuessDotIdFromMouseEvent(event));
        Circle dot = (Circle) scene.lookup(getGuessDotIdFromMouseEvent(event));
        dot.setStrokeWidth(1);
    }
    
    public String getGuessDotIdFromMouseEvent(MouseEvent event)
    {
        return "#"+event.getSource().toString().substring(10, 19);
    }

    @FXML
    private void AIPlayer(ActionEvent event) 
    {
        
    }

    @FXML
    private void openManual(ActionEvent event) 
    {
        enableAndVisible(manualWindow);
    }

    @FXML
    private void okManual(ActionEvent event) 
    {
        disableAndInvisible(manualWindow);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindsjf;

import java.net.URL;
import java.util.ArrayList;
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
    @FXML
    private ProgressIndicator startGameLoadingWheel;
    @FXML
    private Text startGameErrorTextField;
    @FXML
    private GridPane playField;
    @FXML
    private Circle codeDot3;

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
        
        // uiuiui
        /*
        ObservableList rowADotList = dotA1.getParent().getChildrenUnmodifiable();
        rowList.add(rowADotList);
        
        rowList.add(dotB1.getParent().getChildrenUnmodifiable());
        rowList.add(dotC1.getParent().getChildrenUnmodifiable());
        rowList.add(dotD1.getParent().getChildrenUnmodifiable());
        rowList.add(dotE1.getParent().getChildrenUnmodifiable());
        rowList.add(dotF1.getParent().getChildrenUnmodifiable());
        rowList.add(dotG1.getParent().getChildrenUnmodifiable());
        rowList.add(dotH1.getParent().getChildrenUnmodifiable());
        rowList.add(dotI1.getParent().getChildrenUnmodifiable());
        rowList.add(dotJ1.getParent().getChildrenUnmodifiable());
        rowList.add(dotK1.getParent().getChildrenUnmodifiable());
        rowList.add(dotL1.getParent().getChildrenUnmodifiable());
        */
               
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
        
        setAnswer(answerArray);
        nextTurn(); // proceed to next turn
    }

    @FXML
    private void bluePressed(ActionEvent event) 
    {
        currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("blue"))));
    }

    @FXML
    private void greenPressed(ActionEvent event) 
    {
        currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("green"))));
    }

    @FXML
    private void yellowPressed(ActionEvent event) 
    {
        currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("yellow"))));
    }

    @FXML
    private void redPressed(ActionEvent event) 
    {
        currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("red"))));
    }

    @FXML
    private void purplePressed(ActionEvent event) 
    {
        currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("purple"))));
    }

    @FXML
    private void orangePressed(ActionEvent event) 
    {
        currentDot.setFill(Paint.valueOf(dotHexColorList.get(dotColorList.indexOf("orange"))));
    }

    @FXML
    private void newGame(ActionEvent event) 
    {
        newGameWindow.setVisible(true);
        newGameWindow.setDisable(false);
    }

    @FXML
    private void KIPlayer(ActionEvent event) {
    }

    @FXML
    private void Manual(ActionEvent event) {
    }

    @FXML
    private void cancleStartGame(ActionEvent event) 
    {
        newGameWindow.setDisable(true);
        newGameWindow.setVisible(false);
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
        
        startGameLoadingWheel.setVisible(true);
        playField.setDisable(false);
        
        mmg = new MasterMindGame(maxTries, codeLength, numberOfColors);
        System.out.println("Requested game with "+maxTries+" tries, a "+codeLength+" digit code and "+mmg.getNumColor()+" colors.");
        
        newGameWindow.setDisable(true);
        newGameWindow.setVisible(false);
        

    }

    @FXML
    private void guessDot1Clicked(MouseEvent event) 
    {
        
        setCurrentDot(guessDot1);
    }
    
    @FXML
    private void guessDot2Clicked(MouseEvent event) 
    {
        
        setCurrentDot(guessDot2);
    }
    
    @FXML
    private void guessDot3Clicked(MouseEvent event) 
    {
        
        setCurrentDot(guessDot3);
    }
    
    @FXML
    private void guessDot4Clicked(MouseEvent event) 
    {
        
        setCurrentDot(guessDot4);
    }
    
    public void setCurrentDot(Circle dot)
    {
        currentDot = dot;
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
        // show code
        int triesUsed = mmg.getTries();
        
        
        codeDot1.setFill(Paint.valueOf(""));
        
        System.out.println("Game has ended");
        if(mmg.hasWon())
        {
            System.out.println("Player has won! in "+triesUsed);
        }
        else
        {
            System.out.println("Player has lost...");
        }
        
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
}

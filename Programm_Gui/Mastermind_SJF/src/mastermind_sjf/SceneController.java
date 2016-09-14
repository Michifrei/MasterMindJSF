/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind_sjf;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.paint.Paint;

/**
 *
 * @author Michael
 */
public class SceneController implements Initializable {
    
    @FXML
    private HBox row1;
    @FXML
    private Circle dot1;
    @FXML
    private Color x1;
    @FXML
    private Insets x8;
    @FXML
    private Circle dot2;
    @FXML
    private Circle dot3;
    @FXML
    private Circle dot4;
    @FXML
    private Insets x5;
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
    private Insets x4;
    @FXML
    private Insets x2;
    @FXML
    private Button giveUpButton;
    @FXML
    private Font x6;
    @FXML
    private Button guessButton;
    @FXML
    private Font x7;
    
    @FXML
    private void handlexAction(ActionEvent event) {
        System.out.println("You clicked me!");
        dot2.setVisible(true);
        dot2.setFill(Paint.valueOf("#000000"));
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }  
     
}

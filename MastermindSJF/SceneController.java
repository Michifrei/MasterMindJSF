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
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 *
 * @author Michael
 */
public class SceneController implements Initializable {
    
    private Label label;
    @FXML
    private Color x1;
    @FXML
    private Insets x2;
    @FXML
    private Color x6;
    @FXML
    private Insets x3;
    @FXML
    private Insets x4;
    @FXML
    private Insets x5;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

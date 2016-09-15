
package mastermindsjf;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;


public class MastermindSJF extends Application
{
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        
        Scene scene = new Scene(root);

        primaryStage.setTitle("SJF Mastermind");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
     public static void main(String[] args) 
     {
        //System.out.println(getIdArray());
          
        launch(args);
        

     }
}


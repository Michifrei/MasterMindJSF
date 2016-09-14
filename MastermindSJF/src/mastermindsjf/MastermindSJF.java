
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
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        
        Scene scene = new Scene(root);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
     public static void main(String[] args) 
     {
        //System.out.println(getIdArray());
          
        launch(args);

     }
     
     public static String[][] getIdArray()
     {
         String[] idLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
         
         String[][] rowArray = new String[12][4];
         String currentIdString = "";
         
         for(int i=0; i<idLetters.length; i++)
         {
             for(int j=0; j<4; j++)
             {
                 currentIdString = "dot"+idLetters[i]+Integer.toString(j+1);
                 
                 System.out.println("rowArray["+i+"]["+j+"] = "+currentIdString);
                 rowArray[i][j] = currentIdString;
             }
         }
         
         return rowArray;
     }
}


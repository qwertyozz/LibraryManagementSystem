
package amalibrarymanagementsystem;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StudentAboutDevelopersController implements Initializable {

    @FXML
    JFXButton GoBack;
    
    @FXML
    public void StudentGoBack(ActionEvent EventGoBack)throws IOException{
        // LOAD NEW SCENE
        Parent mainViewPoint = FXMLLoader.load(getClass().getResource("StudentMainMenu.fxml"));
        Scene mainViewpointScene = new Scene(mainViewPoint);
        Stage window = (Stage)((Node)EventGoBack.getSource()).getScene().getWindow();
        
        window.setScene(mainViewpointScene);
        window.show();
    }
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    
    
}

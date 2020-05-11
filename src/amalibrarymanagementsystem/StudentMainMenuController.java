
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


public class StudentMainMenuController implements Initializable {
    
    @FXML
    JFXButton Bsearch, Baboutdev;
    
    @FXML
    public void StudentBsearchBookClicked(ActionEvent EventSearch)throws IOException{
        // LOAD NEW SCENE
        Parent mainViewPoint = FXMLLoader.load(getClass().getResource("StudentSearchForBook.fxml"));
        Scene mainViewpointScene = new Scene(mainViewPoint);
        Stage window = (Stage)((Node)EventSearch.getSource()).getScene().getWindow();
        
        window.setScene(mainViewpointScene);
        window.show();
    }
    
    @FXML
    public void StudentAboutDevelopersClicked(ActionEvent EventAboutDevelopers)throws IOException{
        // LOAD NEW SCENE
        Parent mainViewPoint = FXMLLoader.load(getClass().getResource("StudentAboutDevelopers.fxml"));
        Scene mainViewpointScene = new Scene(mainViewPoint);
        Stage window = (Stage)((Node)EventAboutDevelopers.getSource()).getScene().getWindow();
        
        window.setScene(mainViewpointScene);
        window.show();
    }
    
    @FXML
    public void StudentLogOutClicked(ActionEvent EventAboutDevelopers)throws IOException{
        // LOAD NEW SCENE
        Parent mainViewPoint = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene mainViewpointScene = new Scene(mainViewPoint);
        Stage window = (Stage)((Node)EventAboutDevelopers.getSource()).getScene().getWindow();
        
        window.setScene(mainViewpointScene);
        window.show();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}

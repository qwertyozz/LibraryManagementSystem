package amalibrarymanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    @FXML 
    JFXTextField Tusername;
    @FXML
    JFXPasswordField Tpassword;
    @FXML
    JFXButton Blogin, Busername;
    @FXML
    Label Lstatus;
    
    @FXML
    public void Bloginclicked(ActionEvent EventLogin)throws IOException{
        String username = Tusername.getText();
        String password = Tpassword.getText();
        if(username.equals("Admin") && password.equals("AMApasigADMIN")){
            
            // LOAD NEW SCENE
            Parent mainViewPoint = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene mainViewpointScene = new Scene(mainViewPoint);
            Stage window = (Stage)((Node)EventLogin.getSource()).getScene().getWindow();
        
            window.setScene(mainViewpointScene);
            window.show();
        }else if (username.equals("Student") && password.equals("student")){
            // LOAD NEW SCENE
            Parent mainViewPoint = FXMLLoader.load(getClass().getResource("StudentMainMenu.fxml"));
            Scene mainViewpointScene = new Scene(mainViewPoint);
            Stage window = (Stage)((Node)EventLogin.getSource()).getScene().getWindow();
        
            window.setScene(mainViewpointScene);
            window.show();
        }else{
            Lstatus.setText("INVALID LOGIN CREDENTIALS");
            Tusername.setText(null);
            Tpassword.setText(null);
        }
    }
    
    @FXML 
    public void Bexitclicked(ActionEvent EventExit)throws IOException{
        Platform.exit();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}

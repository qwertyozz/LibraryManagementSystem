package amalibrarymanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RemovebookController implements Initializable {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    @FXML
    JFXTextField Ttitle, Tauthor, Tpublisher, Tyear;
    @FXML
    JFXButton Bclear, Bremove, Bback;
    @FXML
    Label Lstatus;
    
    @FXML
    public void BremoveClicked(ActionEvent EventRemove)throws IOException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_data","root","password");
            st = con.createStatement();
            String title = Ttitle.getText();
            String author = Tauthor.getText();
            String publisher = Tpublisher.getText();
            String year = Tyear.getText();
            
            String query = "DELETE FROM books WHERE Title = '"+title+"' AND Author = '"+author+"' AND Publisher = '"+publisher+"' AND Year = '"+year+"' ";
            st.executeUpdate(query);
            Lstatus.setText("Book Successfully Removed");
        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
    
    @FXML
    public void BbackClicked(ActionEvent EventBackRemove)throws IOException{
        // LOAD NEW SCENE
        Parent mainViewPoint = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene mainViewpointScene = new Scene(mainViewPoint);
        Stage window = (Stage)((Node)EventBackRemove.getSource()).getScene().getWindow();
        
        window.setScene(mainViewpointScene);
        window.show();
    }
    
    @FXML
    public void BclearClicked(ActionEvent EventClearRemove)throws IOException{
        Ttitle.setText(null);
        Tauthor.setText(null);
        Tpublisher.setText(null);
        Tyear.setText(null);
        Lstatus.setText(null);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}

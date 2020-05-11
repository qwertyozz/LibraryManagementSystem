
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


public class AddnewbookController implements Initializable {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    @FXML
    JFXButton Bsave, Bback, Bclear;
    @FXML
    JFXTextField Ttitle, Tauthor, Tpublisher, Tyear, Tsection;
    @FXML
    Label Lstatus;
    
    @FXML
    public void BsaveClicked(ActionEvent EventSave)throws IOException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_data","root","password");
            st = con.createStatement();
            String title = Ttitle.getText();
            String author = Tauthor.getText();
            String publisher = Tpublisher.getText();
            String year = Tyear.getText();
            String section = Tsection.getText();
            
            String query = "INSERT INTO books VALUES (null,'"+title+"','"+author+"','"+publisher+"','"+year+"','"+section+"')";
            st.executeUpdate(query);
            Lstatus.setText("Successfully Saved");
        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
    
    @FXML
    public void BbackClicked(ActionEvent EventBack)throws IOException{
        
        // LOAD NEW SCENE
        Parent mainViewPoint = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene mainViewpointScene = new Scene(mainViewPoint);
        Stage window = (Stage)((Node)EventBack.getSource()).getScene().getWindow();
        
        window.setScene(mainViewpointScene);
        window.show();
    }
    
    @FXML
    public void BclearClickedAdd(ActionEvent EventClear)throws IOException{
        Ttitle.setText(null);
        Tauthor.setText(null);
        Tpublisher.setText(null);
        Tyear.setText(null);
        Tsection.setText(null);
        Lstatus.setText(null);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

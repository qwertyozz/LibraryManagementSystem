package amalibrarymanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import java.sql.*;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;


public class SearchBookController implements Initializable {
    
    public Connection con;
    public Statement st;
    public ResultSet rs;
    
    @FXML
    JFXTextField Tsearch;
    @FXML
    JFXButton Bback, Bsearch, Bclear;
    @FXML
    TextArea TAresults;
    @FXML
    Button populate;
    @FXML
    ListView Listview;
    
    @FXML
    public void ButtonBackClickedSearch(ActionEvent EventBackFsearch)throws IOException{
        
        // LOAD NEW SCENE
        Parent mainViewPoint = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene mainViewpointScene = new Scene(mainViewPoint);
        Stage window = (Stage)((Node)EventBackFsearch.getSource()).getScene().getWindow();
        
        window.setScene(mainViewpointScene);
        window.show();
    }
    
    @FXML
    public void ButtonClearClickedSearch(ActionEvent EventClearSearch)throws IOException{
        Tsearch.setText(null);
        TAresults.setText(null);
    }
    
    @FXML
    public void ButtonSearchClicked(ActionEvent EventSearch)throws IOException{
        TAresults.setText(null);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_data","root","password");
            st = con.createStatement();
            String title = Tsearch.getText();
            String like = " '%" + title + "%' ";
            String query = "SELECT * FROM books WHERE Title LIKE " + like;
            
            rs = st.executeQuery(query);
            
            while(rs.next()){
                String Title = rs.getString("Title");
                String Author = rs.getString("Author");
                String Publisher = rs.getString("Publisher");
                String Year = rs.getString("Year");
                String Section = rs.getString("Section");
                
                TAresults.appendText("Title: " + Title + "\n" + "Author: " + Author + "\n" + "Publisher: " + Publisher + "\n"
                + "Year: " + Year + "\n" + "Section: " + Section + "\n"+"\n");
                   
            }
            
        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
    
}
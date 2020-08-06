package amalibrarymanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class BorrowBooksController implements Initializable {

    public Connection con;
    public Statement st;
    public ResultSet rs;

    @FXML
    JFXTextField TBorrower, TUsn, TBookBorrowed, TAuthor, TContact, TCourse;
    @FXML
    JFXButton Bborrow, Breturn, Bclear, Bback, LoadData;
    @FXML
    TextArea TABooksBorrowed;
    @FXML
    Label Lstatus;

    public class DbConnection {

        public void Connectivity() throws SQLException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_data", "root", "password");
                st = con.createStatement();

            } catch (Exception ex) {
                System.out.println("Error: " + ex);
            }
        }
    }

    @FXML
    public void BorrowBook(ActionEvent EventBorrowBook) throws SQLException {
        DbConnection connect = new DbConnection();
        connect.Connectivity();
        String borrower = TBorrower.getText();
        String usn = TUsn.getText();
        String bookborrowed = TBookBorrowed.getText();
        String author = TAuthor.getText();
        String contact = TContact.getText();
        String course = TCourse.getText();
        st.executeUpdate("INSERT INTO borrowed_books VALUES('" + borrower + "','" + usn + "','" + bookborrowed + "','" + author + "','" + contact + "','" + course + "',CURRENT_TIMESTAMP)");
        Lstatus.setText("DATA ADDED SUCCESSFULLY!");

    }

    @FXML
    public void ReturnBook(ActionEvent ReturnBook) throws SQLException {
        DbConnection connect = new DbConnection();
        connect.Connectivity();

        String borrower = TBorrower.getText();
        String usn = TUsn.getText();
        String bookborrowed = TBookBorrowed.getText();
        String author = TAuthor.getText();
        String contact = TContact.getText();
        String course = TCourse.getText();

        String query1 = "DELETE FROM borrowed_books WHERE " + "Name_of_borrower = '" + borrower + "'  OR " + "USN = '" + usn + "'  OR " + "Title_Of_Book_Borrowed = '" + bookborrowed + "' OR " + "Author = '" + author + "' OR " + "Contact_Number = '" + contact + "' OR " + "Course_or_Strand = '" + course + "' ";
        st.executeUpdate(query1);
        Lstatus.setText("DATA REMOVED SUCCESSFULLY!");
    }

    @FXML
    public void clearAll(ActionEvent EventClear) throws IOException {
        TBorrower.setText(null);
        TUsn.setText(null);
        TBookBorrowed.setText(null);
        TAuthor.setText(null);
        TContact.setText(null);
        TCourse.setText(null);
        TABooksBorrowed.setText(null);

    }

    @FXML
    public void BackToMain(ActionEvent EventBackToMain) throws IOException {
        // LOAD NEW SCENE
        Parent mainViewPoint = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene mainViewpointScene = new Scene(mainViewPoint);
        Stage window = (Stage) ((Node) EventBackToMain.getSource()).getScene().getWindow();

        window.setScene(mainViewpointScene);
        window.show();
    }

    @FXML
    public void Refresh(ActionEvent EventRefresh) throws SQLException {
        TABooksBorrowed.setText(null);
        DbConnection connect = new DbConnection();
        connect.Connectivity();

        rs = st.executeQuery("SELECT * FROM borrowed_books");

        while (rs.next()) {
            String borrower = rs.getString("Name_of_borrower");
            String usn = rs.getString("USN");
            String title = rs.getString("Title_Of_Book_Borrowed");
            String author = rs.getString("Author");
            String contact = rs.getString("Contact_Number");
            String course = rs.getString("Course_or_Strand");
            String date = rs.getString("Date_Borrowed");
            
            TABooksBorrowed.appendText("Borrower: " + borrower + "\n" + "USN: " + usn + "\n" + "Book Borrowed: " + title + "\n"
                    + "Author: " + author + "\n" + "Contact No: " + contact + "\n" + "Course: " + course + "\n" + "Date Borrowed: " + date + "\n" + "\n");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}

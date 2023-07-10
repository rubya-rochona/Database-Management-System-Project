/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package clams_combined_library_and_management_systems;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author mdsab
 */
public class DashboardController implements Initializable {

    @FXML
    private Text listedBooks;
    @FXML
    private Text issuedBooks;
    @FXML
    private Text returnedBooks;
    @FXML
    private Text listedAuthors;
    @FXML
    private Text totalHistory;
    @FXML
    private Text regUsers;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Clams_lms;selectMethod=cursor", "sa", "39425153");

            Statement statement = connection.createStatement();
            ResultSet books = statement
                    .executeQuery("SELECT COUNT(id) AS TotalBooks FROM Books_");
            
            while(books.next()){
                listedBooks.setText(books.getString("TotalBooks"));
            }
            ResultSet iBooks = statement
                    .executeQuery("SELECT COUNT(id) AS TotalBorrow FROM Borrow_");
            while(iBooks.next()){
                issuedBooks.setText(iBooks.getString("TotalBorrow"));
            }
            ResultSet rBooks = statement
                    .executeQuery("SELECT COUNT(id) AS TotalReturn FROM Return_");
            while(rBooks.next()){
                returnedBooks.setText(rBooks.getString("TotalReturn"));
            }
            ResultSet lAuthors = statement
                    .executeQuery("SELECT COUNT(Distinct Author) AS TotalAuthor FROM Books_");
             while(lAuthors.next()){
                listedAuthors.setText(lAuthors.getString("TotalAuthor"));
            }
            ResultSet tHistory = statement
                    .executeQuery("SELECT COUNT(Serial) AS TotalHistory FROM History_");
             while(tHistory.next()){
                totalHistory.setText(tHistory.getString("TotalHistory"));
            }
            ResultSet rUsers = statement
                    .executeQuery("SELECT COUNT(id) AS TotalUsers FROM Enthusiast_");
            while(rUsers.next()){
                regUsers.setText(rUsers.getString("TotalUsers"));
            }
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

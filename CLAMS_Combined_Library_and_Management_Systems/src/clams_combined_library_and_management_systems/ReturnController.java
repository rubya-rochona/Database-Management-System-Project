/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package clams_combined_library_and_management_systems;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mdsab
 */
public class ReturnController implements Initializable {

    @FXML
    private TextField e_id;
    @FXML
    private TextField date;
    @FXML
    private TextField book_id;
    @FXML
    private Button submit;

    @FXML
    void submitOnAction(ActionEvent event) {
        if (!e_id.getText().isEmpty() && !book_id.getText().isEmpty() && !book_id.getText().isEmpty()) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Clams_lms;selectMethod=cursor", "sa", "39425153");

                Statement statement = connection.createStatement();
                statement.execute("INSERT INTO Return_(eID, BookId, RetDate) VALUES('"
                        + e_id.getText() + "','"
                        + book_id.getText() + "','"
                        + date.getText().toString() + "')");

                e_id.setText("");
                book_id.setText("");
                date.setText("");
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setTitle("Thank You");
                a.setContentText("Return record successfully added");
                a.setHeaderText("Returned");
                a.show();

            } catch (Exception ex) {
                Logger.getLogger(ReturnController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("FAILED!");
            a.setContentText("Please fill up the empty fields");
            a.setHeaderText("Incomplete");
            a.show();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}

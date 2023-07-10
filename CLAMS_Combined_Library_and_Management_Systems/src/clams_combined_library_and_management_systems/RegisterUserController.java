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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author mdsab
 */
public class RegisterUserController implements Initializable {

    @FXML
    private TextField fname;
    @FXML
    private Text fnamew;
    @FXML
    private TextField dob;
    @FXML
    private Text dobw;
    @FXML
    private TextField contact;
    @FXML
    private Text contactw;
    @FXML
    private TextField address;
    @FXML
    private Text addressw;
    @FXML
    private TextField regdate;
    @FXML
    private Text regdatew;
    @FXML
    private Button regbtn;
    @FXML
    private TextField lname;
    @FXML
    private Text lnamew;

    public boolean existing = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void regbtnAction(ActionEvent event) throws ClassNotFoundException {
        if (!fname.getText().isEmpty() && !lname.getText().isEmpty() && !dob.getText().isEmpty() && !contact.getText().isEmpty() && !address.getText().isEmpty() && !regdate.getText().isEmpty()) {
            fnamew.setText("");
            lnamew.setText("");
            dobw.setText("");
            contactw.setText("");
            addressw.setText("");
            regdatew.setText("");
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Clams_lms;selectMethod=cursor", "sa", "39425153");
                String fn = fname.getText();
                String ln = lname.getText();
                String dobs = this.dob.getText();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement
                        .executeQuery("SELECT FirstName, LastName, DOB FROM Enthusiast_");
                while (resultSet.next()) {
                    if (fn.equals(resultSet.getString("FirstName")) && ln.equals(resultSet.getString("LastName")) && dobs.equals(resultSet.getString("DOB"))) {
                        Alert a = new Alert(AlertType.WARNING);
                        a.setTitle("FAILED!");
                        a.setContentText("User Already Exists. A user cannot be registered multiple times. You can update the users profile informationin the Update User section");
                        a.setHeaderText("Existing User");
                        a.show();
                        existing = true;
                        break;
                    } else {
                        existing = false;
                    }
                }
                if (existing == false) {
                    try {
                        statement.execute("INSERT INTO Enthusiast_(FirstName, LastName, RegDate, DOB, Address, Contact) VALUES('"
                                + fname.getText() + "','"
                                + lname.getText() + "','"
                                + regdate.getText().toString() + "','"
                                + dob.getText().toString() + "','"
                                + address.getText() + "','"
                                + contact.getText() + "');");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    fname.setText("");
                    lname.setText("");
                    dob.setText("");
                    contact.setText("");
                    address.setText("");
                    regdate.setText("");
                    Alert b = new Alert(AlertType.CONFIRMATION);
                    b.setTitle("Registered!");
                    b.setContentText("User Registered Successfully");
                    b.setHeaderText("Thank you");
                    b.show();
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (fname.getText().isEmpty()) {
                fnamew.setText("Please put the First Name");
            }
            if (lname.getText().isEmpty()) {
                lnamew.setText("Please put the Last Name");
            }
            if (dob.getText().isEmpty()) {
                dobw.setText("Please put the Date of Birth");
            }
            if (contact.getText().isEmpty()) {
                contactw.setText("Please put the Contact Number");
            }
            if (address.getText().isEmpty()) {
                addressw.setText("Please put the Address");
            }
            if (regdate.getText().isEmpty()) {
                regdatew.setText("Please put the Registration Date");
            }
        }
    }

}

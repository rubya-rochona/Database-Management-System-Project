/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clams_combined_library_and_management_systems;

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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author mdsab
 */
public class LogInPageController implements Initializable {

    @FXML
    private TextField uniqueIdText;
    @FXML
    private PasswordField passText;
    @FXML
    private Button login;
    @FXML
    private Text warningTextUID;
    @FXML
    private Text warningTextPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginAction(ActionEvent event) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Clams_lms;selectMethod=cursor", "sa", "39425153");

            System.out.println("DATABASE NAME IS:"
                    + connection.getMetaData().getDatabaseProductName());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT UniqueID, Password FROM Credentials_");
            while (resultSet.next()) {
                if (uniqueIdText.getText().equals(resultSet.getString("UniqueID"))) {
                    System.out.println("UniqueID matches!\n");
                    if (passText.getText().contains(resultSet.getString("Password"))) {
                        Parent root = null;
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
                            root = loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Login Successful");
                        Scene scene = new Scene(root);
                        
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("Homepage");
                        stage.show();
                    }else{
                        warningTextUID.setText("");
                        warningTextPass.setText("*Wrong Password!");
                    }
                }else{
                    warningTextPass.setText("");
                    warningTextUID.setText("*Wrong Unique ID!");
                }
                connection.close();
                /*System.out.println("Unique ID:"
                        + resultSet.getString("UniqueID") + "   Password:" + resultSet.getString("Password"));*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Homepage");
        stage.show();*/
    }

}

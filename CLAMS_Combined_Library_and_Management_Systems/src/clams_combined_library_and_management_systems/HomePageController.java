/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clams_combined_library_and_management_systems;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import sun.security.util.Password;
import sun.security.x509.UniqueIdentity;

public class HomePageController implements Initializable {
    
    private int UniqueId;
    private String Password;
    @FXML
    private Button books;
    
    @FXML
    private BorderPane borderPane;
    
    @FXML
    private Button borrow;
    
    @FXML
    private Button dashboard;
    
    @FXML
    private Button editProfile;
    
    @FXML
    private Button exit;
    
    @FXML
    private Button history;
    
    @FXML
    private Text ldes;
    
    @FXML
    private Text llibra;
    
    @FXML
    private Text lname;
    
    @FXML
    private ImageView notifications;
    
    @FXML
    private ImageView profileImage;
    
    @FXML
    private Button register;
    
    @FXML
    private Button ret;
    
    @FXML
    private Button settings;
    
    @FXML
    private Button update;
    
    @FXML
    void booksOnAction(ActionEvent event) {
        loadpage("Books");
        
    }
    
    @FXML
    void borrowOnAction(ActionEvent event) {
        loadpage("Borrow");
    }
    
    @FXML
    void dashboardOnAction(ActionEvent event) {
        loadpage("Dashboard");
    }
    
    @FXML
    void editProfileOnAction(ActionEvent event) {
        loadpage("EditProfile");
    }
    
    @FXML
    void exitOnAction(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    void historyOnAction(ActionEvent event) {
        loadpage("History");
    }
    
    @FXML
    void notificationsOnAction(MouseEvent event) {
        
    }
    
    @FXML
    void registerOnAction(ActionEvent event) {
        loadpage("RegisterUser");
    }
    
    @FXML
    void retOnAction(ActionEvent event) {
        loadpage("Return");
    }
    
    @FXML
    void settingsOnAction(ActionEvent event) {
        loadpage("Settings");
    }
    
    @FXML
    void updateOnAction(ActionEvent event) {
        loadpage("UpdateUser");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadpage("Dashboard");
    }
    
    private void loadpage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        borderPane.setCenter(root);
    }
    
}

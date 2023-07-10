/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clams_combined_library_and_management_systems;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author mdsab
 */
public class CLAMS_Combined_Library_and_Management_Systems extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));

        Scene scene = new Scene(root);
        stage.getIcons().add(new javafx.scene.image.Image("file:X:/CLAMS/CLAMS_Combined_Library_and_Management_Systems/src/clams_combined_library_and_management_systems/img/clams_logo.png"));

        stage.setScene(scene);
        stage.setTitle("CLAMS - Combined Library and Management Systems");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

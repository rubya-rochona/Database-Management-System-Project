/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package clams_combined_library_and_management_systems;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mdsab
 */
public class BooksController implements Initializable {

    @FXML
    private Button addBook;
    @FXML
    private Button updateBook;
    
    
    @FXML
    private RadioButton radioButton;

    @FXML
    private TableColumn<BookSearchModel, String> authorCol;

    @FXML
    private TableColumn<BookSearchModel, Integer> bookIDCol;

    @FXML
    private TableColumn<BookSearchModel, String> catCol;

    @FXML
    private TableColumn<BookSearchModel, String> publisherCol;

    @FXML
    private TableColumn<BookSearchModel, Integer> qtCol;

    @FXML
    private TableColumn<BookSearchModel, String> stCol;

    @FXML
    private TableView<BookSearchModel> tableView;

    @FXML
    private TableColumn<BookSearchModel, String> titleCol;
    
    @FXML
    private TextField searchKey;
    public String availability = "";
    public int click = 0;
    
    @FXML
    void radioButtonOnAction(ActionEvent event) {
        if(click % 2 == 0)
            availability = "available";
        else
            availability = "unavailable";
        System.out.println(availability);
    }

    ObservableList<BookSearchModel> bList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Clams_lms;selectMethod=cursor", "sa", "39425153");
            System.out.println("DATABASE NAME IS:"
                    + connection.getMetaData().getDatabaseProductName());
            String bookQuery = "SELECT ID, Title, Category, Author, Publisher, Status, Qty FROM Books_";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery(bookQuery);

            while (resultSet.next()) {

                Integer outBookID = resultSet.getInt("ID");
                Integer outQty = resultSet.getInt("Qty");
                String outTitle = resultSet.getString("Title");
                String outCat = resultSet.getString("Category");
                String outAuthor = resultSet.getString("Author");
                String outPublisher = resultSet.getString("Publisher");
                String outStatus = resultSet.getString("Status");

                bList.add(new BookSearchModel(outBookID, outQty, outTitle, outCat, outAuthor, outPublisher, outStatus));
            }
            
            bookIDCol.setCellValueFactory(new PropertyValueFactory<>("bookID"));
            qtCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
            titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
            catCol.setCellValueFactory(new PropertyValueFactory<>("category"));
            authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
            publisherCol.setCellValueFactory(new PropertyValueFactory<>("publisher"));
            stCol.setCellValueFactory(new PropertyValueFactory<>("status"));

            tableView.setItems(bList);
            
            
            FilteredList<BookSearchModel> filteredData = new FilteredList<>(bList, b->true);
            
            searchKey.textProperty().addListener((ObservableList, oldValue, newValue)->{
                filteredData.setPredicate(bookSearchModel->{
                    
                    if(newValue.isEmpty() || newValue == null){
                        return true;
                    }
                    String search = newValue.toLowerCase();
                    if(bookSearchModel.getTitle().toLowerCase().indexOf(search)> -1){
                        return true;
                    }else if(bookSearchModel.getBookID().toString().indexOf(search) > -1){
                        return true;
                    }else if(bookSearchModel.getCategory().toLowerCase().indexOf(search) > -1){
                        return true;
                    }else if(bookSearchModel.getAuthor().toLowerCase().indexOf(search) > -1){
                        return true;
                    }else if(bookSearchModel.getPublisher().toLowerCase().indexOf(search) > -1){
                        return true;
                    }else
                        return false;
                });
                
            });
            SortedList<BookSearchModel> sortedList = new SortedList<>(filteredData);
            
            sortedList.comparatorProperty().bind(tableView.comparatorProperty());
            tableView.setItems(sortedList);
        } catch (Exception ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void addBookOnAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddBooks.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.getIcons().add(new javafx.scene.image.Image("file:X:/CLAMS/CLAMS_Combined_Library_and_Management_Systems/src/clams_combined_library_and_management_systems/img/clams_logo.png"));
        stage.setTitle("Add More Books");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void updateBookOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateBook.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.getIcons().add(new javafx.scene.image.Image("file:X:/CLAMS/CLAMS_Combined_Library_and_Management_Systems/src/clams_combined_library_and_management_systems/img/clams_logo.png"));
        stage.setTitle("Update Book");
        stage.setScene(new Scene(root));
        stage.show();
    }

}

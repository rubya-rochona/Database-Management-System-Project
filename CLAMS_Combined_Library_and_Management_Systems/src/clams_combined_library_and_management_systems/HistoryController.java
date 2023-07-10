/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clams_combined_library_and_management_systems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author mdsab
 */
public class HistoryController {

    @FXML
    private TableColumn<?, ?> BorIdCol;

    @FXML
    private TableColumn<?, ?> bookIdCol;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private TableColumn<?, ?> eidCol;

    @FXML
    private TableColumn<?, ?> retIdCol;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchText;

    @FXML
    private TableColumn<?, ?> serialCol;

    @FXML
    private TableColumn<?, ?> statusCol;

    @FXML
    private TableView<?> tableView;

    @FXML
    void SearchBtnAction(ActionEvent event) {

    }
}

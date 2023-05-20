package com.example.system_testing.controller;

import java.util.ArrayList;
import com.example.system_testing.auxiliary.ConstNameWindows;
import com.example.system_testing.auxiliary.WorkWithScene;
import com.example.system_testing.database.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * Класс - контроллер, для управления формой удаления пользователей из системы.
 */

public class DeleteUserController {

    WorkWithScene ws = new WorkWithScene();

    @FXML
    private ComboBox<String> choiceUser_comboBox;

    @FXML
    private Button delete_button;

    @FXML
    private Button goBack_button;

    @FXML
    void initialize() {

        ObservableList<String> groupsList = FXCollections.observableArrayList(choiceUser());
        choiceUser_comboBox.setItems(groupsList);

        goBack_button.setOnAction(event -> {
            goBack();
        });

        delete_button.setOnAction(event -> {
            delete();
        });

    }

    private void delete() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        String user = choiceUser_comboBox.getSelectionModel().getSelectedItem();
        dbHandler.deleteUser(user);
        delete_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_ADMINISTRATOR_MENU);
    }

    private void goBack() {
        goBack_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_ADMINISTRATOR_MENU);
    }

    private ArrayList<String> choiceUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        return dbHandler.getUserList();
    }
}

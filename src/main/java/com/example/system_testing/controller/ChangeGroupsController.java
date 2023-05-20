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
import javafx.scene.control.TextField;

/**
 * Класс - контроллер, для управления формой изменения списка групп студентов: добавление новой / удаление существующей.
 */

public class ChangeGroupsController {

    WorkWithScene ws = new WorkWithScene();

    @FXML
    private Button addGroup_button;

    @FXML
    private ComboBox<String> choiceGroup_comboBox;

    @FXML
    private Button deleteGroup_button;

    @FXML
    private Button goBack_button;

    @FXML
    private TextField nameGroup_textField;

    @FXML
    void initialize() {

        ObservableList<String> groupsList = FXCollections.observableArrayList(choiceGroups());
        choiceGroup_comboBox.setItems(groupsList);

        choiceGroup_comboBox.setOnAction(event -> {
            if (!(choiceGroup_comboBox.getSelectionModel().getSelectedItem().equals(""))) {
                deleteGroup_button.setDisable(false);
            }
        });

        nameGroup_textField.setOnAction(event -> {
            String str = nameGroup_textField.getText();
            if (!(str.equals(""))) {
                addGroup_button.setDisable(false);
            }
        });

        addGroup_button.setOnAction(event -> {
            addGroupToBD();
            addGroup_button.getScene().getWindow().hide();
            ws.getNewWindow(ConstNameWindows.WINDOW_ADMINISTRATOR_MENU);
        });

        goBack_button.setOnAction(event -> {
            goBack();
        });

        deleteGroup_button.setOnAction(event -> {
            delete();
            deleteGroup_button.getScene().getWindow().hide();
            ws.getNewWindow(ConstNameWindows.WINDOW_ADMINISTRATOR_MENU);
        });
    }

    private void delete() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        String group = choiceGroup_comboBox.getSelectionModel().getSelectedItem();
        dbHandler.deleteGroup(group);
    }

    private void addGroupToBD() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        String group = nameGroup_textField.getText();
        dbHandler.addGroup(group);
    }

    private void goBack() {
        goBack_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_ADMINISTRATOR_MENU);
    }

    private ArrayList<String> choiceGroups() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        return dbHandler.getGroupsList();
    }

}


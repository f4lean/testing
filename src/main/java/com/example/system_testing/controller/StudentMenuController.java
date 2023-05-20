package com.example.system_testing.controller;

import com.example.system_testing.auxiliary.ConstNameWindows;
import com.example.system_testing.auxiliary.WorkWithScene;
import com.example.system_testing.database.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import java.util.ArrayList;

/**
 * Класс - контроллер, для управления формой меню студента.
 */

public class StudentMenuController {

    WorkWithScene ws = new WorkWithScene();
    String nameTest;
    int userID;

    @FXML
    private ComboBox<String> choiceTest_comboBox;

    @FXML
    private Button exitFromSystem_button;

    @FXML
    private Button passTest_button;

    @FXML
    void selectTest(ActionEvent event) {
        nameTest = choiceTest_comboBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    void initialize() {

        passTest_button.setOnAction(event -> {
            goToWindowPassTest();
        });

        exitFromSystem_button.setOnAction(event -> {
            exitFromSystem();
        });

    }

    private void exitFromSystem() {
        exitFromSystem_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_AUTHENTICATION);
    }

    private void goToWindowPassTest() {
        passTest_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_PASS_TEST, nameTest, userID);
    }

    private ArrayList<String> choiceTest() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        return dbHandler.getTestListFromGroup(userID);
    }

    public void setUserID(int id) {
        this.userID = id;
        ObservableList<String> testsList = FXCollections.observableArrayList(choiceTest());
        choiceTest_comboBox.setItems(testsList);
    }
}

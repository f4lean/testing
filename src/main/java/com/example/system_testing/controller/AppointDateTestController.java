package com.example.system_testing.controller;

import java.util.ArrayList;
import com.example.system_testing.auxiliary.ConstNameWindows;
import com.example.system_testing.auxiliary.WorkWithScene;
import com.example.system_testing.database.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

/**
 * Класс - контроллер, для управления формой назначения даты теста.
 */

public class AppointDateTestController {

    WorkWithScene ws = new WorkWithScene();
    DataBaseHandler dbHandler = new DataBaseHandler();
    String nameTest;
    String numberGroup;
    String date;

    @FXML
    private Button appointTest_button;

    @FXML
    private ComboBox<String> choiceGroup_comboBox;

    @FXML
    private ComboBox<String> choiceTest_comboBox;

    @FXML
    private DatePicker dateTest_datePicker;

    @FXML
    private Button goBack_button;

    @FXML
    void selectDate(ActionEvent event) {
        date = dateTest_datePicker.getValue().toString();
    }

    @FXML
    void selectTest(ActionEvent event) {
        nameTest = choiceTest_comboBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    void selectGroup(ActionEvent event) {
        numberGroup = choiceGroup_comboBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    void initialize() {

        ObservableList<String> testsList = FXCollections.observableArrayList(choiceTest());
        choiceTest_comboBox.setItems(testsList);

        ObservableList<String> groupsList = FXCollections.observableArrayList(choiceGroups());
        choiceGroup_comboBox.setItems(groupsList);


        appointTest_button.setOnAction(event -> {
            appointTest();
        });

        goBack_button.setOnAction(event -> {
            goBack();
        });

    }

    private ArrayList<String> choiceTest() {
        return dbHandler.getTestList();
    }

    private ArrayList<String> choiceGroups() {
        return dbHandler.getGroupsList();
    }

    private void appointTest() {

        dbHandler.appointDateInDB(date, nameTest, numberGroup);

        appointTest_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_APPOINT_DATE_TEST);

    }

    private void goBack() {
        goBack_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_TEACHER_MENU);
    }

}

package com.example.system_testing.controller;

import java.util.ArrayList;
import com.example.system_testing.auxiliary.ConstNameWindows;
import com.example.system_testing.auxiliary.WorkWithScene;
import com.example.system_testing.database.DataBaseHandler;
import com.example.system_testing.essences.ResultTest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Класс - контроллер, для управления формой просмотра результата прохождения теста группой.
 */

public class ShowResultTestController {

    DataBaseHandler dbHandler = new DataBaseHandler();
    WorkWithScene ws = new WorkWithScene();

    String numberGroup;
    String nameTest;

    @FXML
    private TableColumn<ResultTest, Double> averageAssessment_column;

    @FXML
    private ComboBox<String> choiceGroup_comboBox;

    @FXML
    private ComboBox<String> choiceTest_comboBox;

    @FXML
    private Button goBack_button;

    @FXML
    private TableColumn<ResultTest, String> nameTest_column;

    @FXML
    private TableColumn<ResultTest, String> numGroup_column;

    @FXML
    private TableView<ResultTest> showResult_table;

    @FXML
    private Button showResult_button;

    @FXML
    void pushShowResult(ActionEvent event) {
        showResult();

        choiceTest_comboBox.setDisable(true);
        showResult_button.setDisable(true);
    }

    @FXML
    void initialize() {

        ObservableList<String> groupList = FXCollections.observableArrayList(choiceGroup());
        choiceGroup_comboBox.setItems(groupList);

        choiceGroup_comboBox.setOnAction(event -> {
            numberGroup = choiceGroup_comboBox.getSelectionModel().getSelectedItem();
            if (!(numberGroup.equals(""))) {
                choiceTest_comboBox.setDisable(false);
            }
        });

        ObservableList<String> testsList = FXCollections.observableArrayList(choiceTest());
        choiceTest_comboBox.setItems(testsList);

        choiceTest_comboBox.setOnAction(event -> {
            nameTest = choiceTest_comboBox.getSelectionModel().getSelectedItem();
            showResult_button.setDisable(false);
        });

        goBack_button.setOnAction(event -> {
            goBack();
        });

    }

    private void goBack() {
        goBack_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_ADMINISTRATOR_MENU);
    }

    private void showResult() {

        ArrayList<Integer> listStudentID;
        double averageAssessment = 0;
        int assessment;
        int testID;
        int groupID;
        int sumAssessment = 0;
        int countStudentsPassTest = 0;

        groupID = dbHandler.getGroupID(numberGroup);

        testID = dbHandler.getTestID(nameTest);
        listStudentID = dbHandler.getListStudentID(groupID);

        for (int studentID: listStudentID
             ) {
            assessment = dbHandler.getAssessmentBehindTest(studentID, testID);
            if (assessment >= 0) {
                countStudentsPassTest++;
                sumAssessment += assessment;
            }
        }

        if (sumAssessment != 0 && countStudentsPassTest != 0) {

            averageAssessment = (double) sumAssessment / (double) countStudentsPassTest;

            ResultTest resultTest = new ResultTest(numberGroup, nameTest, averageAssessment);

            ObservableList<ResultTest> list = FXCollections.observableArrayList(resultTest);

            numGroup_column.setCellValueFactory(new PropertyValueFactory<>("numberGroup"));
            nameTest_column.setCellValueFactory(new PropertyValueFactory<>("nameTest"));
            averageAssessment_column.setCellValueFactory(new PropertyValueFactory<>("averageAssessment"));

            showResult_table.setItems(list);

        }

    }

    private ArrayList<String> choiceTest() {
        return dbHandler.getTestList();
    }

    private ArrayList<String> choiceGroup() {
        return dbHandler.getGroupsList();
    }

}

package com.example.system_testing.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.system_testing.auxiliary.ConstNameWindows;
import com.example.system_testing.auxiliary.WorkWithScene;
import com.example.system_testing.database.DataBaseHandler;
import com.example.system_testing.essences.ResultTestItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ShowResultTestItemController {

    DataBaseHandler dbHandler = new DataBaseHandler();
    WorkWithScene ws = new WorkWithScene();

    int numGroup;
    String numberGroup;
    String nameTest;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane ImageButtonHome;

    @FXML
    private TableColumn<ResultTestItem, Integer> assessment_column;

    @FXML
    private ComboBox<String> choiceGroup_comboBox;

    @FXML
    private ComboBox<String> choiceTest_comboBox;

    @FXML
    private TableColumn<ResultTestItem, String> fioStudent_column;

    @FXML
    private Button goBack_button;

    @FXML
    private TableColumn<ResultTestItem, String> num_column;

    @FXML
    private Button showResult_button;

    @FXML
    private TableView<ResultTestItem> showResult_table;

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
        int assessment = -1;
        int count = 0;
        int testID;
        int groupID;

        groupID = dbHandler.getGroupID(numberGroup);

        testID = dbHandler.getTestID(nameTest);
        listStudentID = dbHandler.getListStudentID(groupID);

        ResultTestItem resultTestItem = new ResultTestItem();

        ObservableList<ResultTestItem> list = FXCollections.observableArrayList(resultTestItem);

        for (int studentID: listStudentID
        ) {
            assessment = dbHandler.getAssessmentBehindTest(studentID, testID);
            if (assessment >= 0) {

                if (count == 0) {
                    list.remove(0);
                }
                count++;
                String nameStudent = dbHandler.getNameStudent(studentID);

                list.add(new ResultTestItem(count, nameStudent, assessment));

                num_column.setCellValueFactory(new PropertyValueFactory<>("numGroup"));
                fioStudent_column.setCellValueFactory(new PropertyValueFactory<>("fioStudent"));
                assessment_column.setCellValueFactory(new PropertyValueFactory<>("assessment"));
                showResult_table.setItems(list);
            }
        }
    }

    private ArrayList<String> choiceTest() {
        return dbHandler.getTestList();
    }

    private ArrayList<String> choiceGroup() {
        return dbHandler.getGroupsList();
    }
}

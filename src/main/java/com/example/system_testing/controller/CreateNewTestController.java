package com.example.system_testing.controller;

import com.example.system_testing.auxiliary.ConstNameWindows;
import com.example.system_testing.auxiliary.WorkWithScene;
import com.example.system_testing.database.DataBaseHandler;
import com.example.system_testing.essences.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.util.ArrayList;

/**
 * Класс - контроллер, для управления формой по созданию новых тестов и добавления в них вопросов с ответами.
 */

public class CreateNewTestController {

    WorkWithScene ws = new WorkWithScene();

    @FXML
    private ComboBox<String> choiceDiscipline_comboBox;

    @FXML
    private Button createNewTest_button;

    @FXML
    private Button goBack_button;

    @FXML
    private TextField nameNewTest_textField;

    @FXML
    void initialize() {

        createNewTest_button.setOnAction(event -> {
            createNewTest();
        });

        goBack_button.setOnAction(event -> {
            goBack();
        });

    }

    private void createNewTest() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        Test test = new Test(nameNewTest_textField.getText(), choiceDiscipline_comboBox.getSelectionModel().getSelectedItem());

        dbHandler.createTest(test);

        createNewTest_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_CREATE_QUESTION, test);
    }

    private void goBack() {
        goBack_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_TEACHER_MENU);
    }

    public void setDisciplinesList(ArrayList<String> list) {
        ObservableList<String> disciplinesList = FXCollections.observableArrayList(list);
        choiceDiscipline_comboBox.setItems(disciplinesList);
    }
}

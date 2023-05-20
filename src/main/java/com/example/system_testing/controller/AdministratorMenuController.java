package com.example.system_testing.controller;

import com.example.system_testing.auxiliary.ConstNameWindows;
import com.example.system_testing.auxiliary.WorkWithScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Класс - контроллер, для управления формой меню администратора.
 */

public class AdministratorMenuController {

    WorkWithScene ws = new WorkWithScene();

    @FXML
    private Button changeGroups_button;

    @FXML
    private Button changeDisciplines_button;

    @FXML
    private Button deleteUser_button;

    @FXML
    private Button exitFromSystem_button;

    @FXML
    private Button regStudent_button;

    @FXML
    private Button regTeacher_button;

    @FXML
    private Button showResultTest_button;

    @FXML
    private Button showResultTestItem_button;

    @FXML
    void initialize() {

        regTeacher_button.setOnAction(event -> {
            regTeacher();
        });

        regStudent_button.setOnAction(event -> {
            regStudent();
        });

        deleteUser_button.setOnAction(event -> {
            deleteUser();
        });

        showResultTest_button.setOnAction(event -> {
            showResultTest();
        });

        changeDisciplines_button.setOnAction(event -> {
            changeDisciplines();
        });

        changeGroups_button.setOnAction(event -> {
            changeGroups();
        });

        exitFromSystem_button.setOnAction(event -> {
            exitFromSystem();
        });

        showResultTestItem_button.setOnAction(event -> {
            showResultTestItem();
        });

    }

    private void showResultTestItem() {
        showResultTestItem_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_SHOW_RESULT_TEST_ITEM);
    }

    private void regTeacher() {
        regTeacher_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_REG_TEACHER);
    }

    private void regStudent() {
        regStudent_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_REG_STUDENT);
    }

    private void deleteUser() {
        deleteUser_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_DELETE_USER);
    }

    private void showResultTest(){
        showResultTest_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_SHOW_RESULT_TEST);
    }

    private void changeDisciplines() {
        changeDisciplines_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_CHANGE_DISCIPLINES);
    }

    private void changeGroups() {
        changeGroups_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_CHANGE_GROUPS);
    }

    private void exitFromSystem() {
        exitFromSystem_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_AUTHENTICATION);
    }

}

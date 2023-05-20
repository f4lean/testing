package com.example.system_testing.controller;

import com.example.system_testing.auxiliary.ConstNameWindows;
import com.example.system_testing.auxiliary.WorkWithScene;
import com.example.system_testing.database.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.ArrayList;

/**
 * Класс - контроллер, для управления формой меню преподавателя.
 */

public class TeacherMenuController {

    int userID;
    WorkWithScene ws = new WorkWithScene();

    @FXML
    private Button appointTest_button;

    @FXML
    private Button createNewTest_button;

    @FXML
    private Button exitFromSystem_button;

    @FXML
    private Button updateDropTest_button;

    @FXML
    void initialize() {

        createNewTest_button.setOnAction(event -> {
            goToWindowCreateNewTest();
        });

        updateDropTest_button.setOnAction(event -> {
            goToWindowUpdateDropTest();
        });

        appointTest_button.setOnAction(event -> {
            goToWindowAppointTest();
        });

        exitFromSystem_button.setOnAction(event -> {
            exitFromSystem();
        });

    }

    private void goToWindowCreateNewTest() {
        createNewTest_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_CREATE_NEW_TEST, getDisciplinesListFromTeacher(userID));

    }
    private void goToWindowUpdateDropTest() {
        updateDropTest_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_CHANGE_DROP_TEST);
    }

    private void goToWindowAppointTest() {
        appointTest_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_APPOINT_DATE_TEST);
    }

    private void exitFromSystem() {
        exitFromSystem_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_AUTHENTICATION);
    }

    public void setUserID(int id) {
        userID = id;
    }

    public ArrayList<String> getDisciplinesListFromTeacher (int userID) {
        ArrayList<String> disciplinesList = new ArrayList<>();
        DataBaseHandler dbHandler = new DataBaseHandler();
        disciplinesList = dbHandler.getDisciplinesListFromTeacher(disciplinesList, userID);
        return disciplinesList;
    }
}

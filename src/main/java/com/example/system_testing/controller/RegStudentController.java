package com.example.system_testing.controller;

import java.util.ArrayList;
import com.example.system_testing.auxiliary.ConstNameWindows;
import com.example.system_testing.auxiliary.WorkWithScene;
import com.example.system_testing.database.DataBaseHandler;
import com.example.system_testing.essences.Student;
import com.example.system_testing.essences.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Класс - контроллер, для управления формой регистрации студента в системе.
 */

public class RegStudentController {
    WorkWithScene ws = new WorkWithScene();
    String group;

    @FXML
    private TextField fio_student_field;

    @FXML
    private TextField login_student_field;

    @FXML
    private ComboBox<String> numberGroup_comboBox;

    @FXML
    private TextField password_student_field;

    @FXML
    private Button regStudentInSystemButton;

    @FXML
    void initialize() {

        ObservableList<String> groupsList = FXCollections.observableArrayList(choiceGroups());
        numberGroup_comboBox.setItems(groupsList);

        regStudentInSystemButton.setOnAction(event -> {
            signUpNewStudent();
        });

    }

    private ArrayList<String> choiceGroups() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        return dbHandler.getGroupsList();
    }

    private void signUpNewStudent() {

        DataBaseHandler dbHandler = new DataBaseHandler();

        String fio = fio_student_field.getText();
        String login = login_student_field.getText();
        String password = password_student_field.getText();

        Student student = new Student(fio, group);
        User user = new User(login, password, "student");

        dbHandler.signUpUser(user);
        int userID = dbHandler.getUserID(user);

        group = numberGroup_comboBox.getSelectionModel().getSelectedItem();
        int groupID = dbHandler.getGroupID(group);

        if (userID >= 0 && groupID >= 0) {
            dbHandler.signUpStudent(student, userID, groupID);
            regStudentInSystemButton.getScene().getWindow().hide();
            ws.getNewWindow(ConstNameWindows.WINDOW_ADMINISTRATOR_MENU);
        } else {
            System.out.println("Где-то ошибка!");
        }
    }
}


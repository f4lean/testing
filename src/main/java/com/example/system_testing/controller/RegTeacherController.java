package com.example.system_testing.controller;

import java.util.ArrayList;
import com.example.system_testing.auxiliary.ConstNameWindows;
import com.example.system_testing.auxiliary.WorkWithScene;
import com.example.system_testing.database.DataBaseHandler;
import com.example.system_testing.essences.Teacher;
import com.example.system_testing.essences.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Класс - контроллер, для управления формой регистрации преподавателя в системе.
 */

public class RegTeacherController {
    ArrayList<String> list = new ArrayList<>();
    WorkWithScene ws = new WorkWithScene();

    @FXML
    private Button addDiscipline_button;

    @FXML
    private ComboBox<String> choiceDiscipline_comboBox;

    @FXML
    private TextField fio_teacher_field;

    @FXML
    private TextField login_teacher_field;

    @FXML
    private TextField password_teacher_field;

    @FXML
    private Button regTeacherInSystem_button;

    @FXML
    void initialize() {

        ObservableList<String> disciplinesList = FXCollections.observableArrayList(choiceDisciplines());
        choiceDiscipline_comboBox.setItems(disciplinesList);

        addDiscipline_button.setOnAction(event -> {
            list.add(choiceDiscipline_comboBox.getSelectionModel().getSelectedItem());
        });

        regTeacherInSystem_button.setOnAction(event -> {
            signUpNewTeacher();
        });

    }

    private ArrayList<String> choiceDisciplines() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        return dbHandler.getDisciplinesList();
    }

    private void signUpNewTeacher() {

        DataBaseHandler dbHandler = new DataBaseHandler();

        String fio = fio_teacher_field.getText();
        String login = login_teacher_field.getText();
        String password = password_teacher_field.getText();

        Teacher teacher = new Teacher(fio, list);
        User user = new User(login, password, "teacher");

        dbHandler.signUpUser(user);
        int userID = dbHandler.getUserID(user);
        if (userID >= 0) {
            dbHandler.signUpTeacher(teacher, userID);
            dbHandler.connectTeacherAndDisciplines(teacher);
            regTeacherInSystem_button.getScene().getWindow().hide();
            ws.getNewWindow(ConstNameWindows.WINDOW_ADMINISTRATOR_MENU);
        } else {
            System.out.println("Где-то ошибка!");
        }

    }
}

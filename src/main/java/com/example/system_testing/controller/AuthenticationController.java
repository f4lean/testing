package com.example.system_testing.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.system_testing.auxiliary.ConstTables;
import com.example.system_testing.auxiliary.ConstNameWindows;
import com.example.system_testing.auxiliary.Shake;
import com.example.system_testing.auxiliary.WorkWithScene;
import com.example.system_testing.database.DataBaseHandler;
import com.example.system_testing.essences.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Класс - контроллер, для управления формой идентификации пользователя.
 */

public class AuthenticationController {

    WorkWithScene ws = new WorkWithScene();

    @FXML
    private Button authSigIn_button;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    void initialize() {

        authSigIn_button.setOnAction(event -> {
            String login = login_field.getText();
            String password = password_field.getText();

            if (!login.equals("") && !password.equals("")) {
                loginUser(login, password);
            } else {
                Shake userLoginAnim = new Shake(login_field);
                Shake userPassAnim = new Shake(password_field);
                userLoginAnim.playAnim();
                userPassAnim.playAnim();
            }
        });

    }

    private void loginUser(String login, String password) {

        DataBaseHandler dbHandler = new DataBaseHandler();
        ResultSet resultSet = null;
        int counter = 0;

        User user = new User();
        user.setUserLogin(login);
        user.setUserPassword(password);

        resultSet = dbHandler.getUser(user);

        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (resultSet.getString(ConstTables.USERS_ROLE).equalsIgnoreCase("administrator")) {
                    authSigIn_button.getScene().getWindow().hide();
                    counter++;
                    ws.getNewWindow(ConstNameWindows.WINDOW_ADMINISTRATOR_MENU);
                } else if (resultSet.getString(ConstTables.USERS_ROLE).equalsIgnoreCase("teacher")) {
                    authSigIn_button.getScene().getWindow().hide();
                    counter++;
                    ws.getNewWindow(ConstNameWindows.WINDOW_TEACHER_MENU, resultSet.getInt(ConstTables.USERS_ID));
                } else if (resultSet.getString(ConstTables.USERS_ROLE).equalsIgnoreCase("student")) {
                    authSigIn_button.getScene().getWindow().hide();
                    counter++;
                    ws.getNewWindow(ConstNameWindows.WINDOW_STUDENT_MENU, resultSet.getInt(ConstTables.USERS_ID));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (counter == 0) {
            Shake userLoginAnim = new Shake(login_field);
            Shake userPassAnim = new Shake(password_field);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
    }
}

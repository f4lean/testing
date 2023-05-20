package com.example.system_testing.auxiliary;

import com.example.system_testing.controller.*;
import com.example.system_testing.database.DataBaseHandler;
import com.example.system_testing.essences.Test;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * В классе содержатся методы для перехода между пользовательскими формами и передачи данных между ними.
 */

public class WorkWithScene {

    public void getNewWindow (String window) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(ConstTables.URL_PACKAGE + window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("System testing");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void getNewWindow (String window, Test test) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(ConstTables.URL_PACKAGE + window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("System testing");
        stage.setScene(new Scene(root));

        CreateQuestionController createQuestionController = loader.getController();
        createQuestionController.setNameTest(test);

        stage.show();
    }

    public void getNewWindow (String window, int id) {
        DataBaseHandler dbHandler = new DataBaseHandler();
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource(ConstTables.URL_PACKAGE + window));

        try {
            loader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("System testing");
        stage.setScene(new Scene(root));

        String userRole = dbHandler.getUserRole(id);
        if (userRole.equals("teacher")) {
            TeacherMenuController teacherMenuController = loader.getController();
            teacherMenuController.setUserID(id);
        } else if (userRole.equals("student")) {
            StudentMenuController studentMenuController = loader.getController();
            studentMenuController.setUserID(id);
        }

        stage.show();

    }

    public void getNewWindow (String window, ArrayList<String> list) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(ConstTables.URL_PACKAGE + window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("System testing");
        stage.setScene(new Scene(root));

        CreateNewTestController createNewTestController = loader.getController();
        createNewTestController.setDisciplinesList(list);

        stage.show();
    }

    public void getNewWindow (String window, String str, int userID) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(ConstTables.URL_PACKAGE + window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("System testing");
        stage.setScene(new Scene(root));

        PassTestController passTestController = loader.getController();
        passTestController.setNameTestAndUserID(str, userID);

        stage.show();
    }

}

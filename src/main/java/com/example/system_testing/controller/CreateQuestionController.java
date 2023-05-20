package com.example.system_testing.controller;

import com.example.system_testing.auxiliary.ConstNameWindows;
import com.example.system_testing.auxiliary.WorkWithScene;
import com.example.system_testing.database.DataBaseHandler;
import com.example.system_testing.essences.Answer;
import com.example.system_testing.essences.Question;
import com.example.system_testing.essences.Test;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * Класс - контроллер, для управления формой создания нового вопроса с ответами.
 */

public class CreateQuestionController {
    WorkWithScene ws = new WorkWithScene();
    Question question;
    Test test;

    @FXML
    private TextField answerFour_textField;

    @FXML
    private TextField answerOne_textField;

    @FXML
    private TextField answerThree_textField;

    @FXML
    private TextField answerTwo_textField;

    @FXML
    private Button exit_button;

    @FXML
    private CheckBox isTrueFourCheck;

    @FXML
    private CheckBox isTrueOneCheck;

    @FXML
    private CheckBox isTrueThreeCheck;

    @FXML
    private CheckBox isTrueTwoCheck;

    @FXML
    private TextField nameQuestion_textField;

    @FXML
    private Button saveQuestionInTest_button;

    @FXML
    void initialize() {

        saveQuestionInTest_button.setOnAction(event -> {
            createQuestion();
            saveQuestionInTest();
        });

        exit_button.setOnAction(event -> {
            exitInMenu();
        });

    }

    private void createQuestion() {

        question = new Question(nameQuestion_textField.getText());
        question.addAnswer(new Answer(answerOne_textField.getText(), isTrueOneCheck.isSelected()));
        question.addAnswer(new Answer(answerTwo_textField.getText(), isTrueTwoCheck.isSelected()));
        question.addAnswer(new Answer(answerThree_textField.getText(), isTrueThreeCheck.isSelected()));
        question.addAnswer(new Answer(answerFour_textField.getText(), isTrueFourCheck.isSelected()));

    }

    public void saveQuestionInTest() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        dbHandler.addQuestionInBD(test, question);

        saveQuestionInTest_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_CREATE_QUESTION, test);
    }

    public void setNameTest(Test test) {
        this.test = test;
    }

    private void exitInMenu() {
        exit_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_TEACHER_MENU);
    }
}

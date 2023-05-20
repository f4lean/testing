package com.example.system_testing.controller;

import java.util.ArrayList;
import com.example.system_testing.auxiliary.ConstNameWindows;
import com.example.system_testing.auxiliary.WorkWithScene;
import com.example.system_testing.database.DataBaseHandler;
import com.example.system_testing.essences.Question;
import com.example.system_testing.essences.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

/**
 * Класс - контроллер, для управления формой изменения списков вопросов и удаления тестов.
 */

public class ChangeDropTestController {

    WorkWithScene ws = new WorkWithScene();
    String nameTest;
    ArrayList<String> questionsList = new ArrayList<>();
    Test test;

    @FXML
    private Button addQuestion_button;

    @FXML
    private ComboBox<String> choiceTest_comboBox;

    @FXML
    private ComboBox<String> choiceQuestion_comboBox;

    @FXML
    private Button deleteQuestion_button;

    @FXML
    private Button deleteTest_button;

    @FXML
    private Button goBack_button;

    @FXML
    private Text nameAnswerFour_text;

    @FXML
    private Text nameAnswerOne_text;

    @FXML
    private Text nameAnswerThree_text;

    @FXML
    private Text nameAnswerTwo_text;

    @FXML
    private Text nameQuestion_text;

    @FXML
    void initialize() {

        ObservableList<String> testList = FXCollections.observableArrayList(choiceTest());
        choiceTest_comboBox.setItems(testList);

        choiceTest_comboBox.setOnAction(event -> {
            nameTest = choiceTest_comboBox.getSelectionModel().getSelectedItem();
            questionsList = choiceQuestion();

            ObservableList<String> questionList = FXCollections.observableArrayList(questionsList);
            choiceQuestion_comboBox.setItems(questionList);

            choiceQuestion_comboBox.setOnAction(events -> {

                String nameQuestion = choiceQuestion_comboBox.getSelectionModel().getSelectedItem();
                nameQuestion_text.setText(nameQuestion);

                if (!(nameQuestion.equals(""))) {
                    Question question = new Question();
                    question = getQuestion(nameQuestion);

                    nameAnswerOne_text.setText(question.getAnswerList().get(0).getNameAnswer() + "\t" +
                            question.getAnswerList().get(0).getIsTrueAnswer());
                    nameAnswerTwo_text.setText(question.getAnswerList().get(1).getNameAnswer() + "\t" +
                            question.getAnswerList().get(1).getIsTrueAnswer());
                    nameAnswerThree_text.setText(question.getAnswerList().get(2).getNameAnswer() + "\t" +
                            question.getAnswerList().get(2).getIsTrueAnswer());
                    nameAnswerFour_text.setText(question.getAnswerList().get(3).getNameAnswer() + "\t" +
                            question.getAnswerList().get(3).getIsTrueAnswer());
                }

            });

        });

        addQuestion_button.setOnAction(event -> {
            goToWindowsAddQuestion();
        });

        deleteQuestion_button.setOnAction(event -> {
            deleteQuestion();
        });

        deleteTest_button.setOnAction(event -> {
            deleteTest();
        });

        goBack_button.setOnAction(event -> {
            goBack();
        });

    }

    private Question getQuestion(String nameQuestion) {
        DataBaseHandler dbHandler = new DataBaseHandler();
        return dbHandler.getQuestion(nameQuestion);
    }

    private ArrayList<String> choiceQuestion() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        return dbHandler.getQuestionsList(nameTest);
    }

    private ArrayList<String> choiceTest() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        return dbHandler.getTestList();
    }

    private void goToWindowsAddQuestion() {

        DataBaseHandler dbHandler = new DataBaseHandler();
        test = dbHandler.getTest(nameTest);
        addQuestion_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_CREATE_QUESTION, test);
    }

    private void deleteQuestion() {

        DataBaseHandler dbHandler = new DataBaseHandler();
        String nameQuestion = choiceQuestion_comboBox.getSelectionModel().getSelectedItem();
        dbHandler.deleteQuestion(nameQuestion);

        deleteTest_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_CHANGE_DROP_TEST);
    }

    private void deleteTest() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        nameTest = choiceTest_comboBox.getSelectionModel().getSelectedItem();
        dbHandler.deleteTest(nameTest);

        deleteTest_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_CHANGE_DROP_TEST);
    }

    private void goBack() {
        goBack_button.getScene().getWindow().hide();
        ws.getNewWindow(ConstNameWindows.WINDOW_TEACHER_MENU);
    }

}


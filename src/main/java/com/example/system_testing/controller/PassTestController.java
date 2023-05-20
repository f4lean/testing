package com.example.system_testing.controller;

import java.util.ArrayList;
import com.example.system_testing.auxiliary.ConstNameWindows;
import com.example.system_testing.auxiliary.WorkWithScene;
import com.example.system_testing.database.DataBaseHandler;
import com.example.system_testing.essences.Test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;

/**
 * Класс - контроллер, для управления формой прохождения студентом теста.
 */

public class PassTestController {

    DataBaseHandler dbHandler = new DataBaseHandler();
    WorkWithScene ws = new WorkWithScene();
    Test test = new Test();
    int userID;

    Boolean answerOne;
    Boolean answerTwo;
    Boolean answerThree;
    Boolean answerFour;

    String nameTest;
    int countQuestions = 0, count = 0, countRightAnswer = 0;

    @FXML
    private Button beginTest_button;

    @FXML
    private Button completedTest_button;

    @FXML
    private CheckBox isTrueFour_checkBox;

    @FXML
    private CheckBox isTrueOne_checkBox;

    @FXML
    private CheckBox isTrueThree_checkBox;

    @FXML
    private CheckBox isTrueTwo_checkBox;

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
    private Text nameTest_text;

    @FXML
    private Button nextQuestion_button;

    @FXML
    void initialize() {

    }

    @FXML
    void pushBeginTest(ActionEvent event) {

        beginTest_button.setVisible(false);

        isTrueOne_checkBox.setDisable(false);
        isTrueTwo_checkBox.setDisable(false);
        isTrueThree_checkBox.setDisable(false);
        isTrueFour_checkBox.setDisable(false);

        nextQuestion_button.setDisable(false);

        if (count > 0) {

            nameQuestion_text.setText(test.getQuestionList().get(count - 1).getNameQuestion());
            nameAnswerOne_text.setText(test.getQuestionList().get(count - 1).getAnswerList().get(0).getNameAnswer());
            nameAnswerTwo_text.setText(test.getQuestionList().get(count - 1).getAnswerList().get(1).getNameAnswer());
            nameAnswerThree_text.setText(test.getQuestionList().get(count - 1).getAnswerList().get(2).getNameAnswer());
            nameAnswerFour_text.setText(test.getQuestionList().get(count - 1).getAnswerList().get(3).getNameAnswer());
            count--;

        }
    }

    @FXML
    void pushNextQuestion(ActionEvent event) {

        if (count > 0) {

            answerOne = isTrueOne_checkBox.isSelected();
            answerTwo = isTrueTwo_checkBox.isSelected();
            answerThree = isTrueThree_checkBox.isSelected();
            answerFour = isTrueFour_checkBox.isSelected();

            calculatingResults(count, answerOne, answerTwo, answerThree, answerFour);

            isTrueOne_checkBox.setSelected(false);
            isTrueTwo_checkBox.setSelected(false);
            isTrueThree_checkBox.setSelected(false);
            isTrueFour_checkBox.setSelected(false);

            nameQuestion_text.setText(test.getQuestionList().get(count - 1).getNameQuestion());
            nameAnswerOne_text.setText(test.getQuestionList().get(count - 1).getAnswerList().get(0).getNameAnswer());
            nameAnswerTwo_text.setText(test.getQuestionList().get(count - 1).getAnswerList().get(1).getNameAnswer());
            nameAnswerThree_text.setText(test.getQuestionList().get(count - 1).getAnswerList().get(2).getNameAnswer());
            nameAnswerFour_text.setText(test.getQuestionList().get(count - 1).getAnswerList().get(3).getNameAnswer());
            count--;

            if (count == 0) {

                nextQuestion_button.setDisable(true);
                completedTest_button.setDisable(false);

                completedTest_button.setOnAction(events -> {

                    answerOne = isTrueOne_checkBox.isSelected();
                    answerTwo = isTrueTwo_checkBox.isSelected();
                    answerThree = isTrueThree_checkBox.isSelected();
                    answerFour = isTrueFour_checkBox.isSelected();

                    calculatingResults(count, answerOne, answerTwo, answerThree, answerFour);
                    setAssessment(countRightAnswer, countQuestions);

                    completedTest_button.getScene().getWindow().hide();
                    ws.getNewWindow(ConstNameWindows.WINDOW_STUDENT_MENU, userID);
                });
            }
        }
    }

    private void calculatingResults(int count, Boolean answerOne, Boolean answerTwo, Boolean answerThree, Boolean answerFour) {
        if (test.getQuestionList().get(count).getAnswerList().get(0).getIsTrueAnswer() == answerOne &&
                test.getQuestionList().get(count).getAnswerList().get(1).getIsTrueAnswer() == answerTwo &&
                test.getQuestionList().get(count).getAnswerList().get(2).getIsTrueAnswer() == answerThree &&
                test.getQuestionList().get(count).getAnswerList().get(3).getIsTrueAnswer() == answerFour)
        {
            countRightAnswer++;
        }
    }

    private void setAssessment(int countRightAnswers, int countQuestion) {
        double assessmentDouble = ((double) countRightAnswers / (double) countQuestion) * 5;
        int assessment = (int) assessmentDouble;
        System.out.println(assessment + " - оценочка");
        dbHandler.addAssessmentInBD(test.getNameTest(), userID, assessment);
    }

    public void setNameTestAndUserID(String nameTest, int userID) {
        this.userID = userID;
        this.nameTest = nameTest;
        nameTest_text.setText(nameTest);
        test = dbHandler.getTest(nameTest);

        ArrayList<String> questionList = dbHandler.getQuestionsList(nameTest);
        for (String nameQuestion: questionList
             ) {
            test.addQuestion(dbHandler.getQuestion(nameQuestion));
            countQuestions++;
            count++;
        }
    }
}


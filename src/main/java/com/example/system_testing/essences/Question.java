package com.example.system_testing.essences;

import java.util.ArrayList;

/**
 * Класс для создания объекта - Вопрос.
 */

public class Question {
    private String nameQuestion;
    private ArrayList<Answer> answerList = new ArrayList<>();

    public Question() {
    }

    public Question(String nameQuestion) {
        this.nameQuestion = nameQuestion;
    }

    public String getNameQuestion() {
        return nameQuestion;
    }

    public void setNameQuestion(String nameQuestion) {
        this.nameQuestion = nameQuestion;
    }

    public ArrayList<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<Answer> answerList) {
        this.answerList = answerList;
    }

    public void addAnswer(Answer answer) {
        this.answerList.add(answer);
    }
}

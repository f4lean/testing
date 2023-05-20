package com.example.system_testing.essences;

import java.util.ArrayList;

/**
 * Класс для создания объекта - Тест.
 */

public class Test {
    private String nameTest;
    private String discipline;
    private ArrayList<Question> questionList = new ArrayList<>();

    public Test() {
    }

    public Test(String nameTest) {
        this.nameTest = nameTest;
    }

    public Test(String nameTest, String discipline) {
        this.nameTest = nameTest;
        this.discipline = discipline;
    }

    public String getNameTest() {
        return nameTest;
    }

    public void setNameTest(String nameTest) {
        this.nameTest = nameTest;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
    }

    public void addQuestion(Question question) {
        this.questionList.add(question);
    }
}

package com.example.system_testing.essences;

/**
 * Класс для создания объекта - Ответ.
 */

public class Answer {
    private String nameAnswer;
    boolean isTrueAnswer = false;

    public Answer() {
    }

    public Answer(String nameAnswer, boolean isTrueAnswer) {
        this.nameAnswer = nameAnswer;
        this.isTrueAnswer = isTrueAnswer;
    }

    public String getNameAnswer() {
        return nameAnswer;
    }

    public void setNameAnswer(String nameAnswer) {
        this.nameAnswer = nameAnswer;
    }

    public boolean getIsTrueAnswer() {
        return isTrueAnswer;
    }

    public void setTrueAnswer(boolean trueAnswer) {
        isTrueAnswer = trueAnswer;
    }
}

package com.example.system_testing.essences;

/**
 * Класс для создания объекта - Результат тестирования группы.
 */

public class ResultTest {
    private String numberGroup;
    private String nameTest;
    private double averageAssessment;

    public ResultTest() {
    }

    public ResultTest(String numberGroup, String nameTest, double averageAssessment) {
        this.numberGroup = numberGroup;
        this.nameTest = nameTest;
        this.averageAssessment = averageAssessment;
    }



    public String getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(String numberGroup) {
        this.numberGroup = numberGroup;
    }

    public String getNameTest() {
        return nameTest;
    }

    public void setNameTest(String nameTest) {
        this.nameTest = nameTest;
    }

    public double getAverageAssessment() {
        return averageAssessment;
    }

    public void setAverageAssessment(int averageAssessment) {
        this.averageAssessment = averageAssessment;
    }
}

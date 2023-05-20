package com.example.system_testing.essences;

/**
 * Класс для создания объекта - Результат тестирования группы.
 */

public class ResultTestItem {
    private int numGroup;
    private String fioStudent;
    private int assessment;

    public ResultTestItem() {
    }

    public ResultTestItem(int numGroup, String fioStudent, int assessment) {
        this.numGroup = numGroup;
        this.fioStudent = fioStudent;
        this.assessment = assessment;
    }

    public int getNumGroup() {
        return numGroup;
    }

    public void setNumGroup(int numGroup) {
        this.numGroup = numGroup;
    }

    public String getFioStudent() {
        return fioStudent;
    }

    public void setFioStudent(String fioStudent) {
        this.fioStudent = fioStudent;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }
}

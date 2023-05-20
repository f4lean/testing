package com.example.system_testing.essences;

/**
 * Класс для создания объекта - Студент.
 */

public class Student {
    private String fio;
    private String group;

    public Student() {
    }

    public Student(String fio, String group) {
        this.fio = fio;
        this.group = group;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}

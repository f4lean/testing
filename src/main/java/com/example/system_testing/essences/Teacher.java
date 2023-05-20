package com.example.system_testing.essences;

import java.util.ArrayList;

/**
 * Класс для создания объекта - Преподаватель.
 */

public class Teacher {
    private String fio;
    private ArrayList<String> disciplinesList = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(String fio, ArrayList<String> disciplinesList) {
        this.fio = fio;
        this.disciplinesList.addAll(disciplinesList);
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public ArrayList<String> getDisciplinesList() {
        return disciplinesList;
    }

    public void setDisciplinesList(ArrayList<String> disciplinesList) {
        this.disciplinesList = disciplinesList;
    }

    public void addDisciplines(String disciplines) {
        this.disciplinesList.add(disciplines);
    }
}

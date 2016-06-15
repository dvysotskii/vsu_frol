package com.example.iyufrolov.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iyufrolov on 14.06.2016.
 */
public class Patient {

    int _id;
    String name;
    String surname;

    public Patient(String name, String surname, String diagnosis, String journal, String analysis) {
        this.name = name;
        this.surname = surname;
        this.diagnosis = diagnosis;
        this.journal = journal;
        this.analysis = analysis;
    }

    String diagnosis;
    String journal;
    String analysis;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public Patient(int _id, String name, String surname, String diagnosis, String journal, String analysis) {
        this._id = _id;
        this.name = name;
        this.surname = surname;
        this.diagnosis = diagnosis;
        this.journal = journal;
        this.analysis = analysis;
    }

    public Patient(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public List<String> getView(){
        List<String> result=new ArrayList<>();
        result.add(String.format("%s: %s",HospitalChartDB.COLUMN_NAME,this.name));
        result.add(String.format("%s: %s",HospitalChartDB.COLUMN_SURNAME,this.surname));
        result.add(String.format("%s: %s",HospitalChartDB.COLUMN_DIAGNOSIS,this.diagnosis));
        result.add(String.format("%s: %s",HospitalChartDB.COLUMN_JOURNAL,this.journal));
        result.add(String.format("%s: %s",HospitalChartDB.COLUMN_ANALYSIS,this.analysis));
        return result;
    }
}

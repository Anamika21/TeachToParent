package com.example.amagupta.teachtoparent;

import java.util.Vector;

public class Student {

    private String _rollNumber;
    private  String _myclass;
    private String _section;
    private String _parent;
    private Vector<Subject> _subjects;
    private String _grade;

    public Student() {

    }

    public Student(String rollNumber, String myclass, String section, String parent, Vector<Subject> subjects, String grade) {
        this._rollNumber = rollNumber;
        this._myclass = myclass;
        this._section = section;
        this._parent = parent;
        this._subjects = subjects;
        this._grade = grade;
    }


    public void setRollNumber(String rollNumber) {
        this._rollNumber = rollNumber;
    }
    public String getRollNumber() {
        return this._rollNumber;
    }

    public void setMyClass(String myClass) {
        this._myclass = myClass;
    }
    public String getMyClass() {
        return this._myclass;
    }


    public void setSection(String section) {
        this._section = _section;
    }
    public String getSection() {
        return this._section;
    }

    public void setParent(String parent) {
        this._parent = _parent;
    }
    public String getParent() {
        return this._parent;
    }

    public void setSubjects(Vector<Subject> subjects) {
        this._subjects = subjects;
    }
    public Vector<Subject> getSubjects() {
        return this._subjects;
    }


    public void setGrade(String grade) {
        this._grade = grade;
    }
    public String getGrade() {
        return this._grade;
    }
}

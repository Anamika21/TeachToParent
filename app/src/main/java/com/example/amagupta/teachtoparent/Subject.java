package com.example.amagupta.teachtoparent;

public class Subject{

    private String _subjectName;
    private  String _subjectId;
    private String _teacherId;
    private String _bookName;


    public Subject() {

    }

    public Subject(String subjectName, String subjectId, String teacherId,String bookName ) {
        this._subjectName = subjectName;
        this._subjectId = subjectId;
        this._teacherId = teacherId;
        this._bookName = bookName;
    }




    public void setSubjectName(String subjectName) {
        this._subjectName = subjectName;
    }

    public String getSubjectName() {
        return this._subjectName;
    }

    public void setSubjectId(String subjectId) {
        this._subjectId = subjectId;
    }

    public String getSubjectId() {
        return this._subjectId;
    }
    public void setTeacherId(String teacherId) {
        this._teacherId = teacherId;
    }

    public String getTeacherId() {
        return this._teacherId;
    }
    public void setBookName(String bookName) {
        this._bookName = bookName;
    }

    public String getBookName() {
        return this._bookName;
    }

}
package com.example.amagupta.teachtoparent;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Vector;

public class MyStudentDBHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "studentDB.db";
    private static final String TABLE_STUDENTS = "students";

    public static final String COLUMN_ROLLNUMBER = "rollNumber";
    public static final String COLUMN_CLASS = "class";
    public static final String COLUMN_SECTION = "section";
    public static final String COLUMN_PARENT = "parent";
    public static final String COLUMN_SUBJECTS = "subjects";
    public static final String COLUMN_GRADE = "grade";

    public MyStudentDBHandler(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENTS_TABLE = "CREATE TABLE " +
                TABLE_STUDENTS + "("
                + COLUMN_ROLLNUMBER + " TEXT,"
                + COLUMN_CLASS + " TEXT,"
                + COLUMN_SECTION + " TEXT,"
                + COLUMN_PARENT + " TEXT,"
                + COLUMN_GRADE + " TEXT,"
                + COLUMN_SUBJECTS + " TEXT,"
                + "primary key (" + COLUMN_ROLLNUMBER +", " + COLUMN_CLASS + ", " +  COLUMN_SECTION  + ")" + ")";
        db.execSQL(CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);
    }

    public void addStudent(Student student) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_ROLLNUMBER, student.getRollNumber());
        values.put(COLUMN_CLASS, student.getMyClass());
        values.put(COLUMN_SECTION, student.getSection());
        values.put(COLUMN_PARENT, student.getParent());
        values.put(COLUMN_GRADE, student.getGrade());
        //values.put(COLUMN_SUBJECTS, student.get());
        Vector<Subject> MySubjects = student.getSubjects();
        String studentSubjects = "";
        for(int i = 0; i < MySubjects.size() -  1; i++) {
            studentSubjects += MySubjects.get(i) + ", ";
        }
        studentSubjects += MySubjects.lastElement();
        values.put(COLUMN_SUBJECTS, studentSubjects);
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_STUDENTS, null, values);
        db.close();
    }

    public Student findStudent(String rollNumber, String myClass, String mySection) {
        String query = "Select * FROM " + TABLE_STUDENTS + " WHERE " + COLUMN_ROLLNUMBER + " =  \"" + rollNumber + "\"" + "AND" + COLUMN_CLASS + " =  \"" + myClass + "\"" + "AND" + COLUMN_SECTION + " =  \"" + mySection + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Student student = new Student();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            student.setRollNumber(cursor.getString(0));
            student.setMyClass(cursor.getString(1));
            student.setSection(cursor.getString(2));
            student.setParent(cursor.getString(3));
            student.setGrade(cursor.getString(4));
            String mySubjects = cursor.getString(5);
            Vector<Subject> myVectorSubjects = null;
            String [] splitSubjects = mySubjects.split(",");
            for (int i = 0 ; i < splitSubjects.length ; i++)
            {
             //   MySubjectDBHandler mySubjectDB = new MySubjectDBHandler(this, null, null, 1);
             //   myVectorSubjects.add(new Subject(splitSubjects[i]));
            }
           // student.setSubjects(cursor.getString(2));
            cursor.close();
        } else {
            student = null;
        }
        db.close();
        return student;
    }

}
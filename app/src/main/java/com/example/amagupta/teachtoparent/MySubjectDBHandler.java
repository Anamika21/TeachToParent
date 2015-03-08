package com.example.amagupta.teachtoparent;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySubjectDBHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "subjectDB.db";
    private static final String TABLE_SUBJECTS = "subjects";

    /*
        this._subjectName = subjectName;
        this._subjectId = subjectId;
        this._teacherId = teacherId;
        this._bookName = bookName;
     */
    public static final String COLUMN_SUBJECTID = "subjectID";
    public static final String COLUMN_SUBJECTNAME = "subjectName";
    public static final String COLUMN_TEACHERID = "teacherID";
    public static final String COLUMN_BOOKNAME = "bookName";

    public MySubjectDBHandler(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SUBJECTS_TABLE = "CREATE TABLE " +
                TABLE_SUBJECTS + "("
                + COLUMN_SUBJECTID + " TEXT PRIMARY KEY,"
                + COLUMN_SUBJECTNAME + " TEXT,"
                + COLUMN_TEACHERID + " TEXT,"
                + COLUMN_BOOKNAME + " TEXT"+ ")";
        db.execSQL(CREATE_SUBJECTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBJECTS);
        onCreate(db);
    }

    public void addSubject(Subject subject) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_SUBJECTID, subject.getSubjectId());
        values.put(COLUMN_SUBJECTNAME, subject.getSubjectName());
        values.put(COLUMN_TEACHERID, subject.getTeacherId());
        values.put(COLUMN_BOOKNAME, subject.getBookName());
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_SUBJECTS, null, values);
        db.close();
    }

    public Subject findSubject(String subjectID){  //}, String fieldName) {
        /*String field = "";
        if(fieldName.equals("SUBJECTID"))
            field = "COLUMN_SUBJECTID";
        else if (fieldName.equals("SUBJECTNAME"))
            field = "COLUMN_SUBJECTNAME";
        else if (fieldName.equals("TEACHERID"))
            field = "COLUMN_TEACHERID";
        else if (fieldName.equals("BOOKNAME"))
            field = "COLUMN_TEACHERID";
        */
        String query = "Select * FROM " + TABLE_SUBJECTS + " WHERE " + COLUMN_SUBJECTID + " =  \"" + subjectID + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Subject subject = new Subject();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            subject.setSubjectId(cursor.getString(0));
            subject.setSubjectName(cursor.getString(1));
            subject.setTeacherId(cursor.getString(2));
            subject.setBookName(cursor.getString(3));
            cursor.close();
        } else {
            subject = null;
        }
        db.close();
        return subject;
    }

}
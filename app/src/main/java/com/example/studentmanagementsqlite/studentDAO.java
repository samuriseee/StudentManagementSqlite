package com.example.studentmanagementsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.studentmanagementsqlite.database.DBHelper;
import com.example.studentmanagementsqlite.model.student;

import java.util.ArrayList;
import java.util.List;

public class studentDAO {
    private DBHelper dbHelper;
    public studentDAO(Context context) {
        dbHelper = new DBHelper(context);
    }
    public List<student> getAllStudent() {
        List<student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM student";
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            student student = new student();
            student.setId(cursor.getString(0));
            student.setName(cursor.getString(1));
            student.setAddress(cursor.getString(2));
            student.setPhone(cursor.getString(3));
            studentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        return studentList;
    }
    public student getStudentById(int id) {
        student student = new student();
        String sql = "SELECT * FROM student WHERE studentId = ?";
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery(sql, new String[]{String.valueOf(id)});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            student.setId(cursor.getString(0));
            student.setName(cursor.getString(1));
            student.setAddress(cursor.getString(2));
            student.setPhone(cursor.getString(3));
            cursor.moveToNext();
        }
        cursor.close();
        return student;
    }
    public Boolean insertStudent(student student) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("studentId", student.getId());
        contentValues.put("studentName", student.getName());
        contentValues.put("studentAddress", student.getAddress());
        contentValues.put("studentAge", student.getPhone());
        long result = dbHelper.getWritableDatabase().insert("student", null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
    public void updateStudent(student student) {
        String sql = "UPDATE student SET studentName = ?, studentAddress = ?, studentPhone = ? WHERE studentId = ?";
        dbHelper.getWritableDatabase().execSQL(sql, new String[]{student.getName(), student.getAddress(), student.getPhone(), String.valueOf(student.getId())});
    }
    public Boolean deleteStudent(String id) {
        Cursor cursor = dbHelper.getWritableDatabase().rawQuery("SELECT * FROM student WHERE studentId = ?",new String[] {id});
        if(cursor.getCount()>0){
            long result = dbHelper.getWritableDatabase().delete("student","studentId=?",new String[] {id});
            if(result == -1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

}

package com.example.studentmanagementsqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "StudentManagement.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS student (studentId TEXT PRIMARY KEY, studentName TEXT, studentAge TEXT, studentAddress TEXT)";
        String sqlInsert1 = "INSERT INTO student VALUES ('1', 'Nguyen Van A', '20', 'Ha Noi')";
        String sqlInsert2 = "INSERT INTO student VALUES ('2', 'Nguyen Van B', '21', 'Ha Noi')";

        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.execSQL(sqlInsert1);
        sqLiteDatabase.execSQL(sqlInsert2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

package com.example.studentmanagementsqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.studentmanagementsqlite.adapter.StudentApdater;
import com.example.studentmanagementsqlite.model.student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView_Student;
    ArrayList<student> studentList;
    studentDAO studentDAO;
    StudentApdater studentApdater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView_Student = findViewById(R.id.listView_Student);
        studentDAO = new studentDAO(this);
        studentList = (ArrayList<student>) studentDAO.getAllStudent();
        studentApdater = new StudentApdater(this, studentList);
        listView_Student.setAdapter(studentApdater);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_delete:
                Intent intent2 = new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
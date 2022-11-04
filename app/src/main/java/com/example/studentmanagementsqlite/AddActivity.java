package com.example.studentmanagementsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentmanagementsqlite.model.student;

public class AddActivity extends AppCompatActivity {
    EditText studentId, studentName, studentAddress, studentPhone;
    studentDAO studentDAO;
    student newStudent;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        studentId = findViewById(R.id.student_Id);
        studentName = findViewById(R.id.student_name);
        studentAddress = findViewById(R.id.student_address);
        studentPhone = findViewById(R.id.student_phone);
        btnAdd = findViewById(R.id.btnAddStudent);
        btnAdd.setOnClickListener(v -> {
            studentDAO = new studentDAO(this);
            newStudent = new student(studentId.getText().toString(), studentName.getText().toString(), studentAddress.getText().toString(), studentPhone.getText().toString());
            Boolean checkinsertdata = studentDAO.insertStudent(newStudent);
            if(checkinsertdata==true){
                Toast.makeText(AddActivity.this, "Insert new data successfully", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(AddActivity.this, "Insert new data failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
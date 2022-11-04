package com.example.studentmanagementsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    EditText studentId;
    Button btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        studentId = findViewById(R.id.student_Id);
        btnDelete = findViewById(R.id.btnDeleteStudent);
        btnDelete.setOnClickListener(v -> {
            studentDAO studentDAO = new studentDAO(this);
            Boolean checkinsertdata = studentDAO.deleteStudent(studentId.getText().toString());
            if(checkinsertdata==true){
                Toast.makeText(DeleteActivity.this, "Delete student successfully", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(DeleteActivity.this, "Delete student failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
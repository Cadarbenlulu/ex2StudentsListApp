package com.example.studentslistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


import com.example.studentslistapp.Model.Model;
import com.example.studentslistapp.Model.Student;

public class NewStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        EditText nameET = findViewById(R.id.newStudentNameInput);
        EditText idET = findViewById(R.id.newStudentIDInput);
        EditText phoneET = findViewById(R.id.newStudentPhoneInput);
        EditText addressET = findViewById(R.id.newStudentAddressInput);
        Button saveBtn = findViewById(R.id.newStudentSaveBtn);
        Button cancelBtn = findViewById(R.id.newStudentCancelBtn);
        CheckBox cbBtn = findViewById(R.id.newStudentCB);

        saveBtn.setOnClickListener(view -> {
            String name = nameET.getText().toString();
            String id = idET.getText().toString();
            String phone = phoneET.getText().toString();
            String address = addressET.getText().toString();
            Boolean cb = cbBtn.isChecked();

            Student st = new Student(name, id, phone, address, "", cb);
            Model.instance().addStudent(st);
            finish();

        });

        cancelBtn.setOnClickListener(view -> {finish();});
    }
}
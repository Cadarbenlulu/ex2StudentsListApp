package com.example.studentslistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studentslistapp.Model.Model;
import com.example.studentslistapp.Model.Student;

public class EditStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        EditText nameET = findViewById(R.id.editStudentNameInput);
        EditText idET = findViewById(R.id.editStudentIDInput);
        EditText phoneET = findViewById(R.id.editStudentPhoneInput);
        EditText addressET = findViewById(R.id.editStudentAddressInput);
        CheckBox cbBtn = findViewById(R.id.editStudentCB);
        Button cancelBtn = findViewById(R.id.editStudentCancelBtn);
        Button deleteBtn = findViewById(R.id.editStudentDeleteBtn);
        Button saveBtn = findViewById(R.id.editStudentSaveBtn);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String id = bundle.getString("id");
        String phone = bundle.getString("phone");
        String address = bundle.getString("address");
        Boolean cb = bundle.getBoolean("cb");
        int position = bundle.getInt("pos");

        nameET.setText(name);
        idET.setText(id);
        phoneET.setText(phone);
        addressET.setText(address);
        cbBtn.setChecked(cb);


        saveBtn.setOnClickListener(view -> {
            String newName = nameET.getText().toString();
            String newId = idET.getText().toString();
            String newPhone = phoneET.getText().toString();
            String newAddress = addressET.getText().toString();
            Boolean newCb = cbBtn.isChecked();

            Student st = new Student(newName, newId, newPhone, newAddress, "", newCb);
            Model.instance().updateStudent(position,st);
            finish();
        });

        deleteBtn.setOnClickListener(view -> {
            Model.instance().deleteStudent(position);
            finish();
        });

        cancelBtn.setOnClickListener(view -> {finish();});
    }
}

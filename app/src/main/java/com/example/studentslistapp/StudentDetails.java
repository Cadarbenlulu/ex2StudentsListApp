package com.example.studentslistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class StudentDetails extends AppCompatActivity {

    boolean editMode = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String id = bundle.getString("id");
        String phone = bundle.getString("phone");
        String address = bundle.getString("address");
        Boolean cb = bundle.getBoolean("cb");
        int pos = bundle.getInt("pos");

        TextView nameTV = findViewById(R.id.studentDetailsNameData);
        TextView idTV = findViewById(R.id.studentDetailsIDData);
        TextView phoneTV = findViewById(R.id.studentDetailsPhoneData);
        TextView addressTV = findViewById(R.id.studentDetailsAddressData);
        CheckBox cbV = findViewById(R.id.studentDetailsCB);
        Button editBtn = findViewById(R.id.studentDetailsEditBtn);

        nameTV.setText(name);
        nameTV.setText(name);
        idTV.setText(id);
        phoneTV.setText(phone);
        addressTV.setText(address);
        cbV.setChecked(cb);

        editBtn.setOnClickListener(view -> {
            editMode = true;
            Intent intent = new Intent(StudentDetails.this, EditStudent.class);
            intent.putExtra("name", name);
            intent.putExtra("id", id);
            intent.putExtra("phone", phone);
            intent.putExtra("address", address);
            intent.putExtra("cb", cb);
            intent.putExtra("pos", pos);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (editMode){
            finish();
        }
    }
}
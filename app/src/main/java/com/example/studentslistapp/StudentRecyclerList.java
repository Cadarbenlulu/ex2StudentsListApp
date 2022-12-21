package com.example.studentslistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.studentslistapp.Model.Model;
import com.example.studentslistapp.Model.Student;


import java.util.List;

public class StudentRecyclerList extends AppCompatActivity {
    List<Student> data;
    StudentRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler_list);

        data = Model.instance().getAllStudents();
        RecyclerView list = findViewById(R.id.studentListRV);
        ImageButton addStudentBtn = findViewById(R.id.addStudentBtn);

        addStudentBtn.setOnClickListener(view -> {
            Intent intent = new Intent(StudentRecyclerList.this, NewStudent.class);
            startActivity(intent);
        });

        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentRecyclerAdapter();
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("","row " + position + " was clicked");
                Intent intent = new Intent(StudentRecyclerList.this, StudentDetails.class);
                Student st = data.get(position);
                intent.putExtra("name", st.name);
                intent.putExtra("id", st.id);
                intent.putExtra("phone", st.phone);
                intent.putExtra("address", st.address);
                intent.putExtra("cb", st.cb);
                intent.putExtra("pos", position);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        data = Model.instance().getAllStudents();
        adapter.notifyDataSetChanged();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView id;
        CheckBox cb;

        public StudentViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
             name = itemView.findViewById(R.id.studentName);
             id = itemView.findViewById(R.id.studentID);
             cb = itemView.findViewById(R.id.studentCB);
             cb.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     int pos = (int)cb.getTag();
                     Student st = data.get(pos);
                     st.cb = cb.isChecked();
                 }
             });

             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     int pos = getLayoutPosition();
                     listener.onItemClick(pos);
                 }
             });

        }

        public void bind(Student st, int position) {
            name.setText(st.name);
            id.setText(st.id);
            cb.setChecked(st.cb);
            cb.setTag(position);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {
        OnItemClickListener listener;
        void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;

        }
        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view = getLayoutInflater().inflate(R.layout.student_row, parent,false);


            return new StudentViewHolder(view,listener);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
            Student st = data.get(position);
            holder.bind(st, position);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}
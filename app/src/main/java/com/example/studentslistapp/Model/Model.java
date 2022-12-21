package com.example.studentslistapp.Model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance= new Model();

    public static Model instance() {
        return _instance;
    }

    private Model() {
        addStudent(new Student("Student 1", "349527549", "052-7765542", "Hasharon 17, Hadera", "",false));
        addStudent(new Student("Student 2", "358374659", "050-6782345", "Yehuda Halevi 58, Netanya", "",false));
        addStudent(new Student("Student 3", "253684087", "052-7489901", "Meschit 27, Herzliya", "",false));
        addStudent(new Student("Student 4", "217354628", "054-5528907", "Shlomo ben Yosef 26, Tel Aviv", "",false));
        addStudent(new Student("Student 5", "229876301", "052-0342256", "Bialik 7, Zichron Yaakov", "",false));
        addStudent(new Student("Student 6", "220987412", "050-6761230", "Maale Ze'ev 3, Jerusalem", "",false));

    }

    List<Student> data = new LinkedList<>();

    public List<Student> getAllStudents() {
        return data;
    }

    public void addStudent(Student st) {
        data.add(st);
    }

    public void deleteStudent(int pos){
        data.remove(pos);
    }

    public void updateStudent(int pos, Student st){
        data.set(pos, st);
    }
}

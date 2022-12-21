package com.example.studentslistapp.Model;

public class Student {

    public String name;
    public String id;
    public String phone;
    public String address;
    public String avatarURL;
    public boolean cb;

    public Student(String name, String id, String phone, String address, String avatarURL, boolean cb) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.address = address;
        this.avatarURL = avatarURL;
        this.cb = cb;
    }
}

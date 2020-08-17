package com.example.firebasedatabaseexample;

public class student {
    String sid;
    String name;
    String course;

    public student()
    {

    }

    public student(String sid, String name, String course) {
        this.sid = sid;
        this.name = name;
        this.course = course;
    }

    public String getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
}

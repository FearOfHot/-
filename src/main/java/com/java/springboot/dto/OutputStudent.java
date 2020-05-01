package com.java.springboot.dto;

import com.java.springboot.entity.Student;

public class OutputStudent extends Output{

    private Student student;

    public OutputStudent(String code, String message, Student student) {
        super(code, message);
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


}

package com.java.springboot.entity;

public class Student {

    private String studentId;
    private String studentName;
    private String studentPassword;
    private Double studentBalance;

    private String studentPhoneNumber;
    private String studentAddress;

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public Double getStudentBalance() {
        return studentBalance;
    }

    public void setStudentBalance(Double studentBalance) {
        this.studentBalance = studentBalance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", studentBalance=" + studentBalance +
                ", studentPhoneNumber='" + studentPhoneNumber + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                '}';
    }
}

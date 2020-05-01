package com.java.springboot.service;

import com.java.springboot.entity.Student;

public interface StudentService {

    Student login(String studentId, String studentPassword);

    int updateStudentInfo(String studentPhoneNumber,String studentAddress,String studentId);

    int changeStudentPassword(String studentPassword,String studentId);

    int updateBalance(String orderId,String studentId);

}

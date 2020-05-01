package com.java.springboot.service.impl;

import com.java.springboot.dao.StudentDao;
import com.java.springboot.entity.Student;
import com.java.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student login(String studentId, String studentPassword) {
        return studentDao.findStudent(studentId);
    }

    @Override
    public int updateStudentInfo(String studentPhoneNumber,String studentAddress,String studentId){
        return studentDao.updateStudetnInfo(studentPhoneNumber, studentAddress,studentId);
    }

    @Override
    public int changeStudentPassword(String studentPassword,String studentId){
        return studentDao.changeStudentPasssword(studentPassword, studentId);
    }

    @Override
    public int updateBalance(String orderId,String studentId){
        return studentDao.updateBalance(orderId, studentId);
    }
}

package com.java.springboot.dao;

import com.java.springboot.entity.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao {

    /**
     * 查找对应用户
     */
    @Select("select s.student_id,student_name,student_password,student_phone_number,student_address,student_balance " +
            "from student as s left join info as i " +
            "on s.student_id=i.student_id " +
            "where s.student_id=#{studentId}")
    @Results({
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentPassword", column = "student_password"),
            @Result(property = "studentBalance", column = "student_balance"),
            @Result(property = "studentPhoneNumber", column = "student_phone_number"),
            @Result(property = "studentAddress", column = "student_address"),
    })
    Student findStudent(String studentId);


    /**
     * 更新用户的电话号码及地址
     */
    @Update("update info set student_phone_number=#{studentPhoneNumber},student_address=#{studentAddress} where student_id=#{studentId}")
    int updateStudetnInfo(String studentPhoneNumber,String studentAddress,String studentId);


    /**
     * 修改密码
     */
    @Update("update student set student_password=#{studentPassword} where student_id=#{studentId}")
    int changeStudentPasssword(String studentPassword,String studentId);


    /**
     * 饭卡余额扣费
     */
    @Update("update student set student_balance=student_balance-(select order_price from orders where order_id=#{orderId}) where student_id=#{studentId}")
    int updateBalance(String orderId,String studentId);

}

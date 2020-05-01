package com.java.springboot.dao;


import com.java.springboot.entity.Admin;
import com.java.springboot.entity.Order;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {

    /**
     * 查找对应管理员
     */
    @Select("select * from admins where admin_account=(#{adminAccount})")
    @Results({
            @Result(property = "adminId",column = "admin_id"),
            @Result(property = "adminName",column = "admin_name"),
            @Result(property = "adminAccount",column = "admin_account"),
            @Result(property = "adminPassword",column = "admin_password"),
    })
    Admin findAdmin(String adminAccount);


    /**
     * 查看老密码是否输入正确
     */
    @Select("select count(admin_id) from admins where admin_")


    /**
     * 修改密码
     */
    @Update("update admins set admin_password=#{adminPassword} where admin_account=#{adminAccount}")
    int changeAdminPasssword(String adminPassword,String adminAccount);





}

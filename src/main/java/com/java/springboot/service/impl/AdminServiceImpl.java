package com.java.springboot.service.impl;

import com.java.springboot.dao.AdminDao;
import com.java.springboot.dao.OrderDao;
import com.java.springboot.entity.Admin;
import com.java.springboot.entity.Order;
import com.java.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private OrderDao orderDao;

    @Override
    public Admin login(String adminAccount, String adminPassword) {
        return adminDao.findAdmin(adminAccount);
    }

    @Override
    public int changeAdminPassword(String adminPassword,String adminAccount){
        return adminDao.changeAdminPasssword(adminPassword,adminAccount);
    }

    @Override
    public List<Order> showAllOrders(){
        return orderDao.findAllOrders();
    }
}

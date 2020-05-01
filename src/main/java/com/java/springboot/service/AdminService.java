package com.java.springboot.service;

import com.java.springboot.entity.Admin;
import com.java.springboot.entity.Order;

import java.util.List;

public interface AdminService {

    Admin login(String adminAccount, String adminPassword);

    List<Order> showAllOrders();

    int changeAdminPassword(String adminPassword,String adminAccount);

}

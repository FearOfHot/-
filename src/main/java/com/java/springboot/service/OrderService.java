package com.java.springboot.service;

import com.java.springboot.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> showStudentOrders(String orderUser);

    List<Order> showAllOrders();

    int orderConfirmReceipt(String orderId);

    int orderConfirmSend(String orderId);

    int orderConfirmSubmit(String orderId);

    int insertOrder(Order order);

    int updateOrderRemark(String orderRemark,String orderId);

    int updateOrderAdvice(String orderAdvice,String orderId);

    int sumOrderPrice(String orderId);



}

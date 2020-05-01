package com.java.springboot.service.impl;

import com.java.springboot.dao.OrderDao;
import com.java.springboot.entity.Order;
import com.java.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> showAllOrders(){
        return orderDao.findAllOrders();
    }

    @Override
    public List<Order> showStudentOrders(String orderUser){
        return orderDao.findStudentOrders(orderUser);
    }

    @Override
    public int orderConfirmReceipt(String orderId){
        return orderDao.orderConfirmReceipt(orderId);
    }

    @Override
    public int orderConfirmSend(String orderId){
        return orderDao.orderConfirmSend(orderId);
    }

    @Override
    public int orderConfirmSubmit(String orderId){
        return orderDao.orderConfirmSubmit(orderId);
    }

    @Override
    public int insertOrder(Order order){
        return orderDao.insertOrder(order);
    }

    @Override
    public int updateOrderRemark(String orderRemark,String orderId){
        return orderDao.updateOrderRemark(orderRemark,orderId);
    }

    @Override
    public int updateOrderAdvice(String orderAdvice,String orderId){
        return orderDao.updateOrderAdvice(orderAdvice,orderId);
    }

    @Override
    public int sumOrderPrice(String orderId){
        return orderDao.sumOrderPrice(orderId);
    }



}

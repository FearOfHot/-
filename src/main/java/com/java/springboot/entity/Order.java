package com.java.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Order {

    private String orderId;
    private String orderUser;
    private String orderPhone;
    private Double orderPrice;
    private String orderAddress;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderFinishTime;
    private String orderStatus;
    /**
     * 订单备注
     */
    private String orderRemark;
    /**
     * 订单反馈
     */
    private String orderAdvice;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public Date getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(Date orderStartTime) {
        this.orderStartTime = orderStartTime;
    }

    public Date getOrderFinishTime() {
        return orderFinishTime;
    }

    public void setOrderFinishTime(Date orderFinishTime) {
        this.orderFinishTime = orderFinishTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderAdvices() {
        return orderAdvice;
    }

    public void setOrderAdvices(String orderAdvice) {
        this.orderAdvice = orderAdvice;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderUser='" + orderUser + '\'' +
                ", orderPhone='" + orderPhone + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderStartTime=" + orderStartTime +
                ", orderFinishTime=" + orderFinishTime +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderRemark='" + orderRemark + '\'' +
                ", orderAdvices='" + orderAdvice + '\'' +
                '}';
    }
}

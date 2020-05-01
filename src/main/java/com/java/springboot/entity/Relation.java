package com.java.springboot.entity;

public class Relation {

    private String orderId;
    private String dishName;
    private Integer dishNumber;
    private Double dishTotalPrice;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Integer getDishNumber() {
        return dishNumber;
    }

    public void setDishNumber(Integer dishNumber) {
        this.dishNumber = dishNumber;
    }

    public Double getDishTotalPrice() {
        return dishTotalPrice;
    }

    public void setDishTotalPrice(Double dishTotalPrice) {
        this.dishTotalPrice = dishTotalPrice;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "orderId='" + orderId + '\'' +
                ", dishName='" + dishName + '\'' +
                ", dishNumber=" + dishNumber +
                ", dishTotalPrice=" + dishTotalPrice +
                '}';
    }
}

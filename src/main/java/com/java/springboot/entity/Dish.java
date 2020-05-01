package com.java.springboot.entity;

public class Dish {

    private String dishName;
    private Double dishPrice;
    private String dishDesc;
    /**
     * 菜品销量
     */
    private Integer dishNumber;
    private String dishImageUrl;



    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getDishDesc() {
        return dishDesc;
    }

    public void setDishDesc(String dishDesc) {
        this.dishDesc = dishDesc;
    }

    public Integer getDishNumber() {
        return dishNumber;
    }

    public void setDishNumber(Integer dishNumber) {
        this.dishNumber = dishNumber;
    }

    public String getDishImageUrl() {
        return dishImageUrl;
    }

    public void setDishImageUrl(String dishImageUrl) {
        this.dishImageUrl = dishImageUrl;
    }

    @Override
    public String toString() {
        return "Dish{" +
                ", dishName='" + dishName + '\'' +
                ", dishPrice=" + dishPrice +
                ", dishDesc='" + dishDesc + '\'' +
                ", dishNumber=" + dishNumber +
                ", dishImageUrl='" + dishImageUrl + '\'' +
                '}';
    }
}

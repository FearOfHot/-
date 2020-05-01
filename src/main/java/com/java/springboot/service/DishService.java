package com.java.springboot.service;

import com.java.springboot.entity.Dish;

import java.util.List;

public interface DishService {

    int insertDish(Dish dish);

    int deleteDish(Dish dish);

    List<Dish> queryAllDishes();

}

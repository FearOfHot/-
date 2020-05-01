package com.java.springboot.service.impl;

import com.java.springboot.dao.DishDao;
import com.java.springboot.entity.Dish;
import com.java.springboot.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dishService")
public class DishServiceImpl implements DishService {

    @Autowired
    private DishDao dishDao;

    @Override
    public int insertDish(Dish dish) {
        System.out.println("service插入dish数据");
        int row = dishDao.insertDish(dish);
        return row;
    }

    @Override
    public int deleteDish(Dish dish){
        System.out.println("service删除菜品数据");
        int row = dishDao.deleteDish(dish);
        return row;
    }

    @Override
    public List<Dish> queryAllDishes() {
        System.out.println("service查询所有dish数据");
        return dishDao.queryAllDishes();
    }


}

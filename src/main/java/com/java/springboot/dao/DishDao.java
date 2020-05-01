package com.java.springboot.dao;

import com.java.springboot.entity.Dish;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishDao {

    /**
     * 插入菜品
     */
    @Insert("insert ignore into dishes(dish_name,dish_price,dish_imageurl,dish_desc) " +
            "values(#{dishName},#{dishPrice},#{dishImageUrl},#{dishDesc})")
    @Results({
            @Result(property = "dishName", column = "dish_name"),
            @Result(property = "dishPrice", column = "dish_price"),
            @Result(property = "dishNumber", column = "dish_number"),
            @Result(property = "dishImageUrl", column = "dish_imageurl"),
            @Result(property = "dishDesc", column = "dish_desc"),
    })
    int insertDish(Dish dish);


    /**
     * 查看所有菜
     */
    @Select("select * from dishes")
    @Results({
            @Result(property = "dishName", column = "dish_name"),
            @Result(property = "dishPrice", column = "dish_price"),
            @Result(property = "dishNumber", column = "dish_number"),
            @Result(property = "dishImageUrl", column = "dish_imageurl"),
            @Result(property = "dishDesc", column = "dish_desc"),
    })
    List<Dish> queryAllDishes();


    /**
     * 删除菜品
     */
    @Delete("delete from dishes where dish_name=#{dishName}")
    @Results({
            @Result(property = "dishName", column = "dish_name"),
            @Result(property = "dishPrice", column = "dish_price"),
            @Result(property = "dishNumber", column = "dish_number"),
            @Result(property = "dishImageUrl", column = "dish_imageurl"),
            @Result(property = "dishDesc", column = "dish_desc"),
    })
    int deleteDish(Dish dish);


}

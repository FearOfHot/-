package com.java.springboot.dao;

import com.java.springboot.entity.Relation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationDao {

    /**
     * 查看该菜品是否已经存在
     */
    @Select("select count(order_id) from relation where order_id=#{orderId} and dish_name=#{dishName} limit 1")
    int judgeDishNumber(String orderId,String dishName);


    /**
     * 插入一个从未插入的菜品，刚插入数量默认为1
     */
    @Insert("insert into relation(order_id,dish_name) values(#{orderId},#{dishName})")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "dishName",column = "dish_name"),
            @Result(property = "dishNumber",column = "dish_number"),
            @Result(property = "dishTotalPrice",column = "dish_totalprice"),
    })
    int insertRelation(String orderId,String dishName);


    /**
     * 菜品数量加一
     */
    @Insert("update relation set dish_number=dish_number+1 where dish_name=#{dishName} and order_id=#{orderId}")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "dishName",column = "dish_name"),
            @Result(property = "dishNumber",column = "dish_number"),
            @Result(property = "dishTotalPrice",column = "dish_totalprice"),
    })
    int addDish(String orderId,String dishName);


    /**
     * 菜品数量减一
     */
    @Insert("update relation set dish_number=dish_number-1 where dish_name=#{dishName} and order_id=#{orderId}")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "dishName",column = "dish_name"),
            @Result(property = "dishNumber",column = "dish_number"),
            @Result(property = "dishTotalPrice",column = "dish_totalprice"),
    })
    int reduceDish(String orderId,String dishName);


    /**
     * 删除菜品
     */
    @Insert("delete from relation where order_id=#{orderId} and dish_name=#{dishName} and order_id=#{orderId}")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "dishName",column = "dish_name"),
            @Result(property = "dishNumber",column = "dish_number"),
            @Result(property = "dishTotalPrice",column = "dish_totalprice"),
    })
    int deleteRelation(String orderId,String dishName);


    /**
     * 再最后提交订单的时候更新某一菜品的总价值
     */
    @Update("update relation set dish_totalprice=dish_number*(select dish_price from dishes where dish_name=#{dishName}) " +
            "where order_id=#{orderId} and dish_name=#{dishName}")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "dishName",column = "dish_name"),
            @Result(property = "dishNumber",column = "dish_number"),
            @Result(property = "dishPrice",column = "dish_price"),
            @Result(property = "dishTotalPrice",column = "dish_totalprice"),
    })
    int sumOneDish(String orderId, String dishName);


    /**
     * 查询订单中所有菜品
     */
    @Select("select dish_name,dish_number,dish_totalprice from relation where order_id=#{orderId}")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "dishName",column = "dish_name"),
            @Result(property = "dishNumber",column = "dish_number"),
            @Result(property = "dishPrice",column = "dish_price"),
            @Result(property = "dishTotalPrice",column = "dish_totalprice"),
    })
    List<Relation> showOrderDishes(String orderId);

}

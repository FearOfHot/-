package com.java.springboot.dao;

import com.java.springboot.entity.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    /**
     * 插入订单信息
     */
    @Insert("insert into orders(order_id,order_user,order_phone,order_address) " +
            "values(#{orderId},#{orderUser},#{orderPhone},#{orderAddress})")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "orderUser",column = "order_user"),
            @Result(property = "orderPhone",column = "order_phone"),
            @Result(property = "orderPrice",column = "order_price"),
            @Result(property = "orderAddress",column = "order_address"),
            @Result(property = "orderStartTime",column = "order_starttime"),
            @Result(property = "orderFinishTime",column = "order_finishtime"),
            @Result(property = "orderStatus",column = "order_status"),
            @Result(property = "orderRemark",column = "order_remark"),
            @Result(property = "orderAdvice",column = "order_advice"),
    })
    int insertOrder(Order order);


    /**
     * 查询某学生提交的订单
     */
    @Select("select * from orders where order_status!='-1' and order_status!='0' and order_user=#{orderUser}")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "orderUser",column = "order_user"),
            @Result(property = "orderPhone",column = "order_phone"),
            @Result(property = "orderPrice",column = "order_price"),
            @Result(property = "orderAddress",column = "order_address"),
            @Result(property = "orderStartTime",column = "order_starttime"),
            @Result(property = "orderFinishTime",column = "order_finishtime"),
            @Result(property = "orderStatus",column = "order_status"),
            @Result(property = "orderRemark",column = "order_remark"),
            @Result(property = "orderAdvice",column = "order_advice"),
    })
    List<Order> findStudentOrders(String orderUser);


    /**
     * 查询所有已经提交订单
     */
    @Select("select * from orders where order_status!='-1' and order_status!='0'")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "orderUser",column = "order_user"),
            @Result(property = "orderPhone",column = "order_phone"),
            @Result(property = "orderPrice",column = "order_price"),
            @Result(property = "orderAddress",column = "order_address"),
            @Result(property = "orderStartTime",column = "order_starttime"),
            @Result(property = "orderFinishTime",column = "order_finishtime"),
            @Result(property = "orderStatus",column = "order_status"),
            @Result(property = "orderRemark",column = "order_remark"),
            @Result(property = "orderAdvice",column = "order_advice"),
    })
    List<Order> findAllOrders();


    /**
     * 更改订单状态为已送达
     */
    @Update("update orders set order_status='3' where order_id=#{orderId}")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "orderUser",column = "order_user"),
            @Result(property = "orderPhone",column = "order_phone"),
            @Result(property = "orderPrice",column = "order_price"),
            @Result(property = "orderAddress",column = "order_address"),
            @Result(property = "orderStartTime",column = "order_starttime"),
            @Result(property = "orderFinishTime",column = "order_finishtime"),
            @Result(property = "orderStatus",column = "order_status"),
            @Result(property = "orderRemark",column = "order_remark"),
            @Result(property = "orderAdvice",column = "order_advice"),
    })
    int orderConfirmReceipt(String orderId);


    /**
     * 更改订单状态为已发货
     */
    @Update("update orders set order_status='2' where order_id=#{orderId}")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "orderUser",column = "order_user"),
            @Result(property = "orderPhone",column = "order_phone"),
            @Result(property = "orderPrice",column = "order_price"),
            @Result(property = "orderAddress",column = "order_address"),
            @Result(property = "orderStartTime",column = "order_starttime"),
            @Result(property = "orderFinishTime",column = "order_finishtime"),
            @Result(property = "orderStatus",column = "order_status"),
            @Result(property = "orderRemark",column = "order_remark"),
            @Result(property = "orderAdvice",column = "order_advice"),
    })
    int orderConfirmSend(String orderId);


    /**
     * 更改订单状态为已经提交
     */
    @Update("update orders set order_status='1' where order_id=#{orderId}")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "orderUser",column = "order_user"),
            @Result(property = "orderPhone",column = "order_phone"),
            @Result(property = "orderPrice",column = "order_price"),
            @Result(property = "orderAddress",column = "order_address"),
            @Result(property = "orderStartTime",column = "order_starttime"),
            @Result(property = "orderFinishTime",column = "order_finishtime"),
            @Result(property = "orderStatus",column = "order_status"),
            @Result(property = "orderRemark",column = "order_remark"),
            @Result(property = "orderAdvice",column = "order_advice"),
    })
    int orderConfirmSubmit(String orderId);


    /**
     * 计算订单的总金额
     */
    @Update("update orders set order_price=(select SUM(dish_totalprice) from relation where order_id=#{orderId}) where order_id=#{orderId}")
    int sumOrderPrice(String orderId);


    /**
     * 订单备注
     */
    @Update("update orders set order_remark=#{orderRemark} where order_id=#{orderId}")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "orderUser",column = "order_user"),
            @Result(property = "orderPhone",column = "order_phone"),
            @Result(property = "orderPrice",column = "order_price"),
            @Result(property = "orderAddress",column = "order_address"),
            @Result(property = "orderStartTime",column = "order_starttime"),
            @Result(property = "orderFinishTime",column = "order_finishtime"),
            @Result(property = "orderStatus",column = "order_status"),
            @Result(property = "orderRemark",column = "order_remark"),
            @Result(property = "orderAdvice",column = "order_advice"),
    })
    int updateOrderRemark(String orderRemark,String orderId);

    /**
     * 订单反馈更新
     */
    @Update("update orders set order_advice=#{orderAdvice} where order_id=#{orderId}")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "orderUser",column = "order_user"),
            @Result(property = "orderPhone",column = "order_phone"),
            @Result(property = "orderPrice",column = "order_price"),
            @Result(property = "orderAddress",column = "order_address"),
            @Result(property = "orderStartTime",column = "order_starttime"),
            @Result(property = "orderFinishTime",column = "order_finishtime"),
            @Result(property = "orderStatus",column = "order_status"),
            @Result(property = "orderRemark",column = "order_remark"),
            @Result(property = "orderAdvice",column = "order_advice"),
    })
    int updateOrderAdvice(String orderAdvice,String orderId);



}

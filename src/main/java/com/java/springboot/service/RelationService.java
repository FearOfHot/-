package com.java.springboot.service;

import com.java.springboot.entity.Relation;

import java.util.List;

public interface RelationService {

    int judgeDishNumber(String orderId,String dishName);

    int insertRelation(String orderId,String dishName);

    int addDish(String orderId,String dishName);

    int reduceDish(String orderId,String dishName);

    int deleteRelation(String orderId,String dishName);

    int sumOneDish(String orderId,String dishName);

    List<Relation> showOrderDishes(String orderId);


}

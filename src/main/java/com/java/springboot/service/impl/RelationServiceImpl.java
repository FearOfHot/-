package com.java.springboot.service.impl;

import com.java.springboot.dao.RelationDao;
import com.java.springboot.entity.Relation;
import com.java.springboot.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("relationService")
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationDao relationDao;

    @Override
    public int judgeDishNumber(String orderId,String dishName){
        return relationDao.judgeDishNumber(orderId, dishName);
    }

    @Override
    public int insertRelation(String orderId, String dishName) {
        if(this.judgeDishNumber(orderId, dishName) == 0){
            return relationDao.insertRelation(orderId, dishName);
        }else{
            return -1;
        }
    }

    @Override
    public int addDish(String orderId, String dishName) {
        if(this.judgeDishNumber(orderId, dishName) >= 1){
            return relationDao.addDish(orderId, dishName);
        }else{
            return -1;
        }
    }

    @Override
    public int reduceDish(String orderId, String dishName) {
        if(this.judgeDishNumber(orderId, dishName) >= 1){
            return relationDao.reduceDish(orderId, dishName);
        }else{
            return -1;
        }
    }

    @Override
    public int deleteRelation(String orderId, String dishName) {
        if(this.judgeDishNumber(orderId, dishName) == 1){
            return relationDao.deleteRelation(orderId, dishName);
        }else{
            return -1;
        }
    }

    @Override
    public int sumOneDish(String orderId,String dishName){
        return relationDao.sumOneDish(orderId, dishName);
    }

    @Override
    public List<Relation> showOrderDishes(String orderId){
        return relationDao.showOrderDishes(orderId);
    }
}

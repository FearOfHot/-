package com.java.springboot.controller;

import com.java.springboot.entity.Admin;
import com.java.springboot.entity.Dish;
import com.java.springboot.entity.Order;
import com.java.springboot.entity.Relation;
import com.java.springboot.service.AdminService;
import com.java.springboot.service.DishService;
import com.java.springboot.service.OrderService;
import com.java.springboot.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private DishService dishService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RelationService relationService;

    /**
     * 管理员账号登陆
     * @param params
     * @return
     */
    @PostMapping("/login")
    public Admin check(@RequestParam Map<String, String> params,HttpSession session){
        String adminAccount = params.get("adminAccount");
        String adminPassword = params.get("adminPassword");
        Admin admin = adminService.login(adminAccount,adminPassword);
        //将管理员对象放入session中便于使用
        session.setAttribute("admin", admin);
        //有效期为 180 * 60 秒
        session.setMaxInactiveInterval(180 * 60);
        return admin;
    }

    /**
     * 查看所有菜品
     * @return
     */
    @RequestMapping("/show/dishes")
    public List<Dish> showAllDishes(){
        return dishService.queryAllDishes();
    }

    /**
     * 删除已有菜品
     */
    @PostMapping("/delete_dish")
    public int deleteDish(@RequestParam Map<String,String> params){
        String dishName = params.get("dishName");
        Dish dish = new Dish();
        dish.setDishName(dishName);
        return dishService.deleteDish(dish);
    }

    /**
     * 新增菜品
     */
    @PostMapping("/insert_dish")
    public int insertDish(@RequestParam Map<String,String> params){
        String dishName = params.get("dishName");
        Double dishPrice = Double.parseDouble(params.get("dishPrice"));
        String dishImageUrl = params.get("dishImageUrl");
        String dishDesc = params.get("dishDesc");
        Dish dish = new Dish();
        dish.setDishName(dishName);
        dish.setDishPrice(dishPrice);
        dish.setDishImageUrl(dishImageUrl);
        dish.setDishDesc(dishDesc);
        return dishService.insertDish(dish);
    }

    /**
     * 查看所有提交的订单
     * @return
     */
    @RequestMapping("/showAllOrders")
    public List<Order> showAllOrders(){
        return orderService.showAllOrders();
    }


    /**
     * 确认订单已经发货
     */
    @PostMapping("/confirm_send")
    public int orderConfirmSend(@RequestParam Map<String,String> params){
        String orderId = params.get("orderId");
        return orderService.orderConfirmSend(orderId);
    }


    /**
     * 确认送达
     */
    @PostMapping("/confirm_receipt")
    public int orderConfirmReceipt(@RequestParam Map<String,String> params){
        String orderId = params.get("orderId");
        return orderService.orderConfirmReceipt(orderId);
    }


    /**
     * 查看某一订单有什么菜品
     */
    @PostMapping("/showOrderDishes")
    public List<Relation> showOrderDishes(@RequestParam Map<String,String> params){
        return relationService.showOrderDishes(params.get("orderId"));
    }


    /**
     * 修改密码
     */
    @PostMapping("/changeAdminPassword")
    public int changeAdminPassword(@RequestParam Map<String,String> params,HttpSession session){
        String adminPassword = params.get("adminPassword");
        Admin admin = (Admin) session.getAttribute("admin");
        return adminService.changeAdminPassword(adminPassword,admin.getAdminAccount());
    }


}

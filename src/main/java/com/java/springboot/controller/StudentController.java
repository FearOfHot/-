package com.java.springboot.controller;

import com.java.springboot.entity.Dish;
import com.java.springboot.entity.Order;
import com.java.springboot.entity.Relation;
import com.java.springboot.entity.Student;
import com.java.springboot.service.DishService;
import com.java.springboot.service.OrderService;
import com.java.springboot.service.RelationService;
import com.java.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private DishService dishService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RelationService relationService;

    /**
     * 学生账号登陆
     * @param params
     * @return
     */
    @PostMapping("/login")
    public Student check(@RequestParam Map<String, String> params, HttpSession session){
        String studentId = params.get("studentId");
        String studentPassword = params.get("studentPassword");
        Student student = studentService.login(studentId,studentPassword);
        //将学生对象放入session中便于使用
        session.setAttribute("student", student);
        //有效期为 180 * 60 秒
        session.setMaxInactiveInterval(180 * 60);
        return student;
    }


    /**
     * 更新息用户地址信
     */
    @PostMapping("/updateStudentInfo")
    public int updateStudentInfo(@RequestParam Map<String,String> params,HttpSession session){
        String studentPhoneNumber = params.get("studentPhoneNumber");
        String studentAddress = params.get("studentAddress");
        Student student = (Student) session.getAttribute("student");
        return studentService.updateStudentInfo(studentPhoneNumber,studentAddress,student.getStudentId());
    }

    /**
     * 修改密码
     */
    @PostMapping("/changeStudentPassword")
    public int changeStudentPassword(@RequestParam Map<String,String> params,HttpSession session){
        String studentPassword = params.get("studentPassword");
        Student student = (Student) session.getAttribute("student");
        return studentService.changeStudentPassword(studentPassword,student.getStudentId());
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
     * 购物车菜品的新增
     */
    @PostMapping("/insertRelation")
    public int insertRelation(@RequestParam Map<String,String> params,HttpSession session){
        Order order = (Order) session.getAttribute("order");
        String dishName = params.get("dishName");
        return relationService.insertRelation(order.getOrderId(),dishName);
    }

    /**
     * 购物车已有菜品的增加
     */
    @PostMapping("/addDish")
    public int addDish(@RequestParam Map<String,String> params,HttpSession session){
        Order order = (Order) session.getAttribute("order");
        String dishName = params.get("dishName");
        return relationService.addDish(order.getOrderId(),dishName);
    }

    /**
     * 购物车已有菜品的减少
     */
    @PostMapping("/reduceDish")
    public int reduceDish(@RequestParam Map<String,String> params,HttpSession session){
        Order order = (Order) session.getAttribute("order");
        String dishName = params.get("dishName");
        return relationService.reduceDish(order.getOrderId(),dishName);
    }

    /**
     * 购物车菜品的删除
     */
    @PostMapping("/deleteRelation")
    public int deleteRelation(@RequestParam Map<String,String> params,HttpSession session){
        Order order = (Order) session.getAttribute("order");
        String dishName = params.get("dishName");
        return relationService.deleteRelation(order.getOrderId(),dishName);
    }


    /**
     * 计算更新订单内某一菜品的总价格
     */
    @PostMapping("/sumOneDish")
    public int sumOneDish(@RequestParam Map<String,String> params,HttpSession session){
        Order order = (Order) session.getAttribute("order");
        String dishName = params.get("dishName");
        return relationService.sumOneDish(order.getOrderId(),dishName);
//        return relationService.sumOneDish(params.get("orderId"),params.get("dishName"));
    }


    /**
     * 计算更新购物车内的总价格
     */
    @PostMapping("/sumOrderPrice")
    public int sumOrderPrice(@RequestParam Map<String,String> params,HttpSession session){
        Order order = (Order) session.getAttribute("order");
        return orderService.sumOrderPrice(order.getOrderId());
//        String orderId = params.get("orderId");
//        return orderService.sumOrderPrice(orderId);
    }

    /**
     * 购物车，即实时的菜品选择
     * 同时可作为最终订单查询
     */
    @PostMapping("/showOrderDishes")
    public List<Relation> showOrderDishes(@RequestParam Map<String,String> params, HttpSession session){
        Order order = (Order) session.getAttribute("order");
        return relationService.showOrderDishes(order.getOrderId());
//        return relationService.showOrderDishes(params.get("orderId"));
    }


    /**
     * 生成订单
     */
    @PostMapping("/insert_order")
    public int insertOrder(@RequestParam Map<String,String> params,HttpSession session){
        //从session中获取所登录的学生账号信息
        Student student = (Student) session.getAttribute("student");
        //自动根据当前时间及学生学号生成订单号
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
        String orderId = student.getStudentId() + format.format(date).replace("-","");
        //获取所登录的账号的信息
        String orderUser = student.getStudentName();
        String orderPhone = student.getStudentPhoneNumber();
        String orderAddress = student.getStudentAddress();
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderUser(orderUser);
        order.setOrderPhone(orderPhone);
        order.setOrderAddress(orderAddress);
        //将订单放入session中便于使用
        session.setAttribute("order", order);
        //有效期为 180 * 60 秒
        session.setMaxInactiveInterval(180 * 60);
        return orderService.insertOrder(order);
    }


    /**
     * 订单提交，将其状态位改变
     */
    @PostMapping("/confirmSubmit")
    public int orderConfirmSubmit(@RequestParam Map<String,String> params,HttpSession session){
        Order order = (Order) session.getAttribute("order");
        return orderService.orderConfirmSubmit(order.getOrderId());
    }


    /**
     * 添加订单备注
     */
    @PostMapping("/updateOrderRemark")
    public int updateOrderRemark(@RequestParam Map<String,String> params,HttpSession session){
        Order order = (Order) session.getAttribute("order");
        String orderRemark = params.get("orderRemark");
        return orderService.updateOrderRemark(orderRemark,order.getOrderId());
//        return orderService.updateOrderRemark(params.get("orderRemark"),params.get("orderId"));
    }


    /**
     * 提交反馈
     */
    @PostMapping("/updateOrderAdvice")
    public int updateOrderAdvice(@RequestParam Map<String,String> params,HttpSession session){
        Order order = (Order) session.getAttribute("order");
        String orderAdvice = params.get("orderAdvice");
        return orderService.updateOrderAdvice(orderAdvice,order.getOrderId());
//        return orderService.updateOrderAdvice(params.get("orderAdvice"),params.get("orderId"));
    }


    /**
     * 查询该学生的所有订单
     */
    @PostMapping("/showStudentOrders")
    public List<Order> showStudentOrders(@RequestParam Map<String,String> params,HttpSession session){
        Student student = (Student) session.getAttribute("student");
        return orderService.showStudentOrders(student.getStudentName());
//        return orderService.showStudentOrders(params.get("orderUser"));
    }


    /**
     * 更新学生饭卡余额
     */
    @PostMapping("/updateBalance")
    public int updateBalance(@RequestParam Map<String,String> params,HttpSession session){
        Student student = (Student) session.getAttribute("student");
        Order order = (Order) session.getAttribute("order");
        return studentService.updateBalance(order.getOrderId(),student.getStudentId());
//        return studentService.updateBalance(params.get("orderId"),params.get("studentId"));
    }



}

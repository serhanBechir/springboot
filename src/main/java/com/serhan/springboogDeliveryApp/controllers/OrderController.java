package com.serhan.springboogDeliveryApp.controllers;

import com.serhan.springboogDeliveryApp.model.Order;
import com.serhan.springboogDeliveryApp.model.User;
import com.serhan.springboogDeliveryApp.services.OrderService;
import com.serhan.springboogDeliveryApp.services.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @ModelAttribute("order")
    public Order order(){
        Order order = new Order();
        order.setUser(userService.getLoggedUser());
        return order;
    }

    @GetMapping("/orders")
    public String showOrders(Model model){
      return showOrdersPaginated(1, model);
    }
    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable (value = "id") int id){
        orderService.deleteOrderById(id);
        return "redirect:/orders";
    }
    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute("order") Order order){//or choose to use DTO
        orderService.addOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/page/{pageNumber}")
    public String showOrdersPaginated(@PathVariable(value = "pageNumber") int pageNumber, Model model){
        int pageSize = 7;

        Page<Order> page = orderService.findOrdersPaginatedForCurrentUser(pageNumber, pageSize);
        List<Order> orderList = page.getContent();
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("orderList", orderList);
        return "orders";
    }



}

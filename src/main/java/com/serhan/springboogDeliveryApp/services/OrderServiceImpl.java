package com.serhan.springboogDeliveryApp.services;

import com.serhan.springboogDeliveryApp.model.Order;
import com.serhan.springboogDeliveryApp.model.User;
import com.serhan.springboogDeliveryApp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

//    @Override
//    public List<Order> getAllOrdersByUserEmail() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//       return orderRepository.findByUser_Email(email);
//    }

    @Override
    public void deleteOrderById(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Page<Order> findOrdersPaginatedForCurrentUser(int pageNumber, int pageSize) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        return  orderRepository.findByUser_Email(email,pageable);
    }





}

package com.serhan.springboogDeliveryApp.services;

import com.serhan.springboogDeliveryApp.model.Order;
import com.serhan.springboogDeliveryApp.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {

    //public List<Order> getAllOrdersByUserEmail();
    public void deleteOrderById(int id);
    public void addOrder(Order order);
    public Page<Order> findOrdersPaginatedForCurrentUser(int pageNumber, int pageSize);

}

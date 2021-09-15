package com.serhan.springboogDeliveryApp.repository;

import com.serhan.springboogDeliveryApp.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    //public List<Order> findByUser_Email(String email);
    Page<Order> findByUser_Email(String email, Pageable pageable);
}

package com.serhan.springboogDeliveryApp.services;

import com.serhan.springboogDeliveryApp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends UserDetailsService {

    public User save(User user);
    public User findByEmail(String email);
    public User getLoggedUser();
}

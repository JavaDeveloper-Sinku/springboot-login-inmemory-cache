package com.example.loginSystem.service;



import com.example.loginSystem.cache.UserCacheService;
import com.example.loginSystem.entity.User;
import org.springframework.stereotype.Service;


import com.example.loginSystem.entity.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserCacheService userCacheService;

    public AuthService(UserCacheService userCacheService) {
        this.userCacheService = userCacheService;
    }

    public String login(String username, String password) {
        User user = userCacheService.getUserByUsername(username); // Cache works
        if (!user.getPassword().equals(password)) {
            return "Invalid credentials";
        }
        System.out.println("Login successful → Data from cache if DB HIT not printed");
        return "Login successful";
    }
}

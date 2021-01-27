package com.suze.test;

import com.suze.pojo.User;
import com.suze.service.UserService;
import com.suze.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-06 10:51 PM
 */
public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "bbj168","666666","bbj168@qq.com"));
        userService.registUser(new User(null, "abc168","666666","abc168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "bbj168", "666666", null)));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("bbj169")){
            System.out.println("Username already exists");
        }else{
            System.out.println("Valid username");
        }
    }
}
package com.suze.dao;

import com.suze.pojo.User;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-06 6:43 PM
 */
public interface UserDao {




    public User queryUserByUsername(String username);
    public User queryUserByUsernameAndPassword(String username, String password);


    public int saveUser(User user);

}

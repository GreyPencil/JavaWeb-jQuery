package com.suze.service;

import com.suze.pojo.User;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-06 10:18 PM
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);


    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);


    /**
     * 检查用户名是否可用
     * @return true表示用户名已存在， false表示用户名可用
     */
    public boolean existsUsername(String username);


}

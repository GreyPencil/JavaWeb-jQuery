package com.suze.service.impl;

import com.suze.dao.UserDao;
import com.suze.dao.impl.UserDaoImpl;
import com.suze.pojo.User;
import com.suze.service.UserService;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-06 10:42 PM
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);

    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        if (userDao.queryUserByUsername(username) == null) {
            return false;
        } else {
            return true;
        }
    }
}

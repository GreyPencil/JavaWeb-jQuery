package com.suze.test;

import com.suze.dao.UserDao;
import com.suze.dao.impl.UserDaoImpl;
import com.suze.pojo.User;
import org.junit.Test;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-06 7:00 PM
 */
public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
//        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("admin"));

        if(userDao.queryUserByUsername("admin") == null){
            System.out.println("Valid username");
                }else{
            System.out.println("Username already exists");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
//        System.out.println(userDao.queryUserByUsernameAndPassword("admis","admin"));
        if(userDao.queryUserByUsernameAndPassword("admisn", "admin") == null){
            System.out.println("Failed to login");
        }else{
            System.out.println("Login successfully!");
        }

    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"suze","suze190616","suzekang@gmail.com")));
        //return 1: save successfully
    }
}

package com.suze.test;

import com.suze.web.UserServlet;

import java.lang.reflect.Method;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-10 3:34 PM
 */
public class UserServletTest {

    public void login(){
        System.out.println("login方法调用");
    }
    public void regist(){
        System.out.println("regist方法调用");
    }
    public void updateUser(){
        System.out.println("updateUser方法调用");
    }
    public void updateUserPassword(){
        System.out.println("updateUserPassword方法调用");
    }

    public static void main(String[] args) {
        String action = "login";

        try {
            //获取action业务鉴别字符串，获取相应的业务 方法反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
//            System.out.println(method);
            //调用目标业务 方法
            method.invoke(new UserServletTest());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

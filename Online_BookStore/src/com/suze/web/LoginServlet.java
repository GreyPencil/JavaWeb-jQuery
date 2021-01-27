package com.suze.web;

import com.suze.pojo.User;
import com.suze.service.UserService;
import com.suze.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-07 4:11 PM
 */
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginuser = userService.login(new User(null, username, password,null));
        if(loginuser == null){

            req.setAttribute("msg", "Invalid username or password!");
            req.setAttribute("username", username);


//            System.out.println("Invalid username or password");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);

        }else{
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);

        }
    }
}

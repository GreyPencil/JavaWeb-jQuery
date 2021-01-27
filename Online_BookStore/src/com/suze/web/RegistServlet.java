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
 * @create 2021-01-06 10:59 PM
 */
public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

//        System.out.println(username);


        if ("bnbnp".equalsIgnoreCase(code)) {

            if (userService.existsUsername(username)) {

                System.out.println("用户名【" + username + "】已存在");
                req.setAttribute("msg","Username already exists");
                req.setAttribute("username", username);
                req.setAttribute("email", email);


                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {

                userService.registUser(new User(null, username, password, email));

                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        } else {
            //把回显信息，保存在request域中
            req.setAttribute("msg","Verification code error");
            req.setAttribute("username", username);
            req.setAttribute("email", email);





            System.out.println(("验证码【" + code + "】错误"));

            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }


    }
}

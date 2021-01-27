package com.suze.web;

import com.google.gson.Gson;
import com.suze.pojo.User;
import com.suze.service.UserService;
import com.suze.service.impl.UserServiceImpl;
import com.suze.test.UserServletTest;
import com.suze.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-09 11:28 PM
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        boolean existsUsername = userService.existsUsername(username);

        Map<String,Object> resultMap = new HashMap<>();

        resultMap.put("existsUsername", existsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        resp.getWriter().write(json);

    }


        /**
         * Dealing with login
         *
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    protected void signout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {

            req.setAttribute("msg", "Invalid username or password!");
            req.setAttribute("username", username);


//            System.out.println("Invalid username or password");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);

        } else {
            //登陆成功
            req.getSession().setAttribute("user", loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);

        }
    }


    /**
     * Dealing with regist
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);

        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);



        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");



        /*Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + Arrays.asList(entry.getValue()));
        }*/
//        User user = new User();
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());


        if (token != null && token.equalsIgnoreCase(code)) {

            if (userService.existsUsername(username)) {

//                System.out.println("Username【" + username + "】already exists");
                req.setAttribute("msg", "Username already exists");
                req.setAttribute("username", username);
                req.setAttribute("email", email);


                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {

                userService.registUser(new User(null, username, password, email));

                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        } else {
            //把回显信息，保存在request域中
            req.setAttribute("msg", "Verification code error");
            req.setAttribute("username", username);
            req.setAttribute("email", email);


            System.out.println(("验证码【" + code + "】错误"));

            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        /*if ("login".equals(action)) {

            login(req, resp);

        } else if ("regist".equals(action)) {

            regist(req, resp);

        }*/
        try {
            //获取action业务鉴别字符串，获取相应的业务 方法反射对象
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
//            System.out.println(method);
            //调用目标业务 方法
            method.invoke(this, req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

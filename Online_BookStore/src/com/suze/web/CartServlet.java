package com.suze.web;

import com.google.gson.Gson;
import com.suze.pojo.Book;
import com.suze.pojo.Cart;
import com.suze.pojo.CartItem;
import com.suze.service.BookService;
import com.suze.service.impl.BookServiceImpl;
import com.suze.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-16 2:04 PM
 */
public class CartServlet extends BaseServlet{

    private BookService bookService= new BookServiceImpl();

    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println("addtocart");
        //获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);

        Book book = bookService.queryBookById(id);

        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());

        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

//        System.out.println(cart);

        resp.sendRedirect(req.getHeader("Referer"));

        req.getSession().setAttribute("lastName", cartItem.getName());



    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        cart.deleteItem(id);

        resp.sendRedirect(req.getHeader("Referer"));

    }



    protected void clearCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        cart.clear();
        resp.sendRedirect(req.getHeader("Referer"));

    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if(cart != null){
            cart.updateCount(id, count);
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 调用bookService.queryBookById(id):Book得到图书的信息
        Book book = bookService.queryBookById(id);
        // 把图书信息，转换成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        // 调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

//        System.out.println(cart);
        // 最后一个添加的商品名称
        req.getSession().setAttribute("lastName", cartItem.getName());

        //6、返回购物车总的商品数量和最后一个添加的商品名称
        Map<String,Object> resultMap = new HashMap<String,Object>();

        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);

        resp.getWriter().write(resultMapJsonString);

    }

}

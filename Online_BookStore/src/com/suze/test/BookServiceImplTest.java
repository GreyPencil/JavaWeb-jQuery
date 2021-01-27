package com.suze.test;

import com.suze.pojo.Book;
import com.suze.pojo.Page;
import com.suze.service.BookService;
import com.suze.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-11 5:50 PM
 */
public class BookServiceImplTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(1,"三体3","刘慈欣", new BigDecimal("38.99"), 1100, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(26);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(21,"三体2","刘慈欣", new BigDecimal("38.99"), 1100, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(25));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }


    @Test
    public void pagebyprice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE, 10, 50));
    }
}

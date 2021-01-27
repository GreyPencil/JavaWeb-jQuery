package com.suze.service;

import com.suze.pojo.Book;
import com.suze.pojo.Page;

import java.util.List;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-11 5:17 PM
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();


    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}

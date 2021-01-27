package com.suze.test;

import com.suze.dao.BookDao;
import com.suze.dao.impl.BookDaoImpl;
import com.suze.pojo.Book;
import com.suze.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author suzekang
 * @Description
 * @create 2021-01-11 3:51 PM
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "金瓶梅", "兰陵笑笑生", new BigDecimal("88.99"), 1100, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(2);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "金瓶梅-四大名著", "兰陵笑笑生", new BigDecimal("88.99"), 1100, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {

        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());

    }

    @Test
    public void queryForPageTotalCountByprice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));

    }

    @Test
    public void queryForPageItems() {
        for (Book queryForPageItem : bookDao.queryForPageItems(8, 4)) {
            System.out.println(queryForPageItem);

        }

    }

    @Test
    public void queryForPageItemsbyprice() {
        for (Book queryForPageItem : bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE, 10,50)) {
            System.out.println(queryForPageItem);

        }

    }

}
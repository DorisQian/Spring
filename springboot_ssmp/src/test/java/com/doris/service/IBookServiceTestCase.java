package com.doris.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.doris.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class IBookServiceTestCase {

    @Autowired
    private IBookService bookService;

    @Test
    public void testGetById(){
        System.out.println(bookService.getById(1));
    }

    @Test
    public void testSave(){
        Book book = new Book();
        book.setName("test222");
        book.setType("test221");
        book.setDescription("test223");
        bookService.save(book);
    }

    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setId(6);
        book.setName("test223");
        book.setType("test224");
        book.setDescription("test225");
        bookService.updateById(book);
    }

    @Test
    public void testDelete(){
        bookService.removeById(7);
    }

    @Test
    public void testGetAll(){
        List<Book> bookList = bookService.list();
        System.out.println(bookList);
    }

    @Test
    public void testGetPage(){
        IPage<Book> page = new Page<Book>(1, 3);
        bookService.page(page);
        System.out.println(page.getRecords());
    }
}

package com.doris.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doris.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookService bookService;

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
        bookService.update(book);
    }

    @Test
    public void testDelete(){
        bookService.delete(6);
    }

    @Test
    public void testGetAll(){
        List<Book> bookList = bookService.getAll();
        System.out.println(bookList);
    }

    @Test
    public void testGetPage(){
        IPage page = bookService.getPage(1,3);
        System.out.println(page.getRecords());
    }
}

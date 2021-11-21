package com.doris.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.doris.Dao.BookDao;
import com.doris.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testGetById(){
        Book book = bookDao.selectById(1);
        System.out.println(book);
    }

    @Test
    public void testSave(){
        Book book = new Book();
        book.setName("test111");
        book.setType("test112");
        book.setDescription("test113");
        bookDao.insert(book);
    }

    @Test
    public void testFindAll(){
        List<Book> bookList = bookDao.selectList(null);
        System.out.println(bookList);
    }

    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setId(5);
        book.setName("test211");
        book.setType("test212");
        book.setDescription("test213");
        bookDao.updateById(book);
    }

    @Test
    public void testDelete(){
        bookDao.deleteById(4);
    }

    @Test
    public void testGetPage(){
        IPage page = new Page(1, 2);
        bookDao.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }

    @Test
    public void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "Spring");
        bookDao.selectList(qw);
    }

    @Test
    public void testGetBy2(){
        String name = null;
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name != null, Book::getName, "Spring");
        bookDao.selectList(lqw);
    }

}

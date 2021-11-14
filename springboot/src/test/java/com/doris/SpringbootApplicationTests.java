package com.doris;

import com.doris.controller.BookController;
import com.doris.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    //注入要测试的对象，执行对象的方法
    @Autowired
    private BookController bookController;

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
//        bookController.getById();
        System.out.println(userDao.getById(1));
        System.out.println("springboot test");
    }

}

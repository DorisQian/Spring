package com.doris.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;

public class JdbcTemplateTest {
    @Test
    public void test1(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db1");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        JdbcTemplate template = new JdbcTemplate();
        //设置数据源
        template.setDataSource(dataSource);
        int test1 = template.update("insert into user values(?,?,?)", 5,"test1", "123455");
        System.out.println(test1);
    }

    @Test
    public void test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = app.getBean(JdbcTemplate.class);
        int test2 = template.update("insert into user values(?,?,?)", 6,"test2", "123455");
        System.out.println(test2);
    }
}

package com.doris.test;

import com.doris.domian.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MyBatisTest {

    @Test
    public void test1() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：xml中的namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        //模拟对象
        User user = new User();
        user.setUsername("testtrue");
        user.setPassword("123456");

        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作，参数：xml中的namespace+id
        sqlSession.insert("userMapper.save", user);
        //mybatis默认不提交，需要提交
//        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        //模拟对象
        User user = new User();
        user.setId(8);
        user.setPassword("test111");

        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：xml中的namespace+id
        sqlSession.update("userMapper.update", user);
        //mybatis默认不提交，需要提交
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：xml中的namespace+id
        sqlSession.delete("userMapper.del", 8);
        //mybatis默认不提交，需要提交
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test5() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：xml中的namespace+id
        User user= sqlSession.selectOne("userMapper.findById", 1);
        System.out.println(user);
        //释放资源
        sqlSession.close();
    }
}

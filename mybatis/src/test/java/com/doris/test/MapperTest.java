package com.doris.test;

import com.doris.Dao.UserMapper;
import com.doris.domian.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapperTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User condition = new User();
//        condition.setId(1);
//        condition.setUsername("zhangsan");
//        condition.setPassword("123");

        List<User> userList = mapper.findByCondition(condition);
        System.out.println(userList);

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        List<User> byIds = mapper.findByIds(ids);
        System.out.println(byIds);


    }
}

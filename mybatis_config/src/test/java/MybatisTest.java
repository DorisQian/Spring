import com.doris.domain.Order;
import com.doris.domain.User;
import com.doris.mapper.OrderMapper;
import com.doris.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
//    order前的查询，User中没有映射order 用db1库
//    @Test
//    public void testInsert() throws IOException {
//        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//
//        User user = new User();
//        user.setUsername("test4");
//        user.setPassword("123456");
//        user.setBirthday(new Date());
//
//        mapper.save(user);
//
//        sqlSession.commit();
//        sqlSession.close();
//    }

    @Test
    public void testFindById() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.findById(1);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testFindAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //设置分页相关参数 当前页，每页显示的条数
        PageHelper.startPage(2, 2);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        //获得与分页相关的参数
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println("当前页 " + pageInfo.getPageNum());
        System.out.println("每页条数 " + pageInfo.getSize());
        System.out.println("总记录数 " + pageInfo.getTotal());
        System.out.println("总页数 " + pageInfo.getPages());
        System.out.println("上一页 " + pageInfo.getPrePage());
        System.out.println("下一页 " + pageInfo.getNextPage());
        System.out.println("是否第一页 " + pageInfo.isIsFirstPage());
        System.out.println("是否最后一页 " + pageInfo.isIsLastPage());
        sqlSession.close();
    }

    //一对多
    @Test
    public void testFindAllOrder() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orders = mapper.findAll();
        for (Order order : orders) {
            System.out.println(order);
        }


        sqlSession.close();
    }

    //多对一
    @Test
    public void testFindD2o () throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.findAll2();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    //多对多 用spring_test库
    @Test
    public void testFindD2d () throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.findUserAndRole();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}

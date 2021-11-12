import com.doris.domain.User;
import com.doris.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    UserMapper mapper =null;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("test11");
        user.setPassword("1111");
        mapper.save(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(7);
        user.setUsername("test12");
        user.setPassword("123");
        mapper.update(user);
    }

    @Test
    public void testDelete(){
        mapper.delete(7);
    }

    @Test
    public void testFindById(){
        User user = mapper.findById(1);
        System.out.println(user);
    }

    @Test
    public void testFindAll(){
        List<User> user = mapper.findAll();
        for (User user1 : user) {
            System.out.println(user1);
        }
    }

    @Test
    public void testFindUserAndOrder(){
        List<User> userList = mapper.findUserAndOrder();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserAndRole(){
        List<User> userList = mapper.findUserAndRole();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}

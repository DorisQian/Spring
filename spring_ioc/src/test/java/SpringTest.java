import com.doris.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    /**
     * scope 默认 singleton 单例 加载配置文件时创建
     *prototype 多例 调用getBean时创建，对象长时间不用时 被java垃圾回收期回收，GC
     * Bean 创建的无参构造
     */
    @Test
    public void testScope(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
        app.close();
    }
}

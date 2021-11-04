package com.doris.service.impl;

import com.doris.dao.UserDao;
import com.doris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id ="userService" class="com.doris.service.impl.UserServiceImpl">
//</bean>
//@Component("userService")
@Service("userService")
//@Scope("prototype")
@Scope("singleton")
public class UserServiceImpl implements UserService {
    @Value("${jdbc.driver}") //直接从容器中找key，xml中已经加载了文件，能找到key
    private String driver;



    //<property name="userDao" ref="userDao"></property>
//    @Autowired //按照数据类型从spring容器中进行匹配
//    @Qualifier("userDao") //按照id的名称从容器中匹配，但是此处要结合autowired一起用
    @Resource(name="userDao") //@Resource = @Autowired + @Qualifier("userDao")
    private UserDao userDao;

    //使用注解可以不用写set方法
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }
}

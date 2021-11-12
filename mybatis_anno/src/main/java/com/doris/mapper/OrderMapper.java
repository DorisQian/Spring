package com.doris.mapper;

import com.doris.domain.Order;
import com.doris.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    @Select("select * from roles where id=#{id}")
    public List<Order> findByUid(int id);

    @Select("select * from orders")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(
                    property = "user", //封装的属性名
                    column = "uid", //根据字段去查询user表数据
                    javaType = User.class, //要封装的实体类型
                    //select属性 代表查询哪个接口的方法获取数据
                    one = @One(select = "com.doris.mapper.UserMapper.findById")
            )
//            @Result(column = "uid", property = "user.id"),
//            @Result(column = "username", property = "user.username"),
//            @Result(column = "password", property = "user.password"),
//            @Result(column = "birthday", property = "user.birthday"),
    })
    public List<Order> findAll();
}

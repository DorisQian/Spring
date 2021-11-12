package com.doris.mapper;

import com.doris.domain.Order;
import com.doris.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Insert("insert into user1 values(#{id}, #{username}, #{password}, #{birthday})")
    public void save(User user);

    @Select("select * from user1 where id=#{id}")
    public User findById(Integer id);

    @Select("select * from user1")
    public List<User> findAll();

    @Update("update user1 set username=#{username}, password=#{password} where id=#{id}")
    public void update(User user);

    @Delete("delete from user1 where id=#{id}")
    public void delete(Integer id);

    @Select("select * from user1")
    @Results({
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "orders",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.doris.mapper.OrderMapper.findByUid")
            )
    })
    public List<User> findUserAndOrder();

    @Select("select * from user1")
    @Results({
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.doris.mapper.RoleMapper.findByUid")

            )
    })
    public List<User> findUserAndRole();
}

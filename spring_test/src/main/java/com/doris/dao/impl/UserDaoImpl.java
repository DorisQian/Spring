package com.doris.dao.impl;

import com.doris.dao.UserDao;
import com.doris.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template;

    public void setJdbcTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<User> findAll() {
        String sql = "select * from sys_user";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    public Long add(final User user) {
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                //使用原始的jdbc实现
                String sql = "insert into sys_user values(?,?,?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setObject(2, user.getUsername());
                preparedStatement.setString(3,user.getEmail());
                preparedStatement.setString(4,user.getPassword());
                preparedStatement.setString(5,user.getPhoneNum());
                return preparedStatement;
            }
        };
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(creator, keyHolder);
        long userId = keyHolder.getKey().longValue();
        return userId;
    }

    public void addRelate(Long userID, Long roleId){
        String sql = "insert into sys_user_role values(?,?)";
        template.update(sql, userID, roleId);
    }

    public void delete(Long userId) {
        String sqlRelate = "delete from sys_user_role where userId=?";
        String sql = "delete from sys_user where id=?";
        template.update(sqlRelate, userId);
        template.update(sql, userId);
    }

    public User login(String username, String password) throws EmptyResultDataAccessException {
        String sql = "select * from sys_user where username=? and password=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
    }
}

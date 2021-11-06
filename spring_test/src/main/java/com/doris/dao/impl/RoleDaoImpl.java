package com.doris.dao.impl;

import com.doris.dao.RoleDao;
import com.doris.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RoleDaoImpl implements RoleDao {

    //@Autowired
    private JdbcTemplate template;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    public List<Role> findAll() {
        String sql = "select * from sys_role";
        return template.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
    }

    public void save(Role role) {
        String sql = "insert into sys_role values(?, ?, ?)";
        template.update(sql,  null, role.getRoleName(), role.getRoleDesc());
    }

    public List<Role> findByUserId(Long userId) {
        String sql = "select * from sys_role a inner join sys_user_role b on a.id = b.roleId where userId=?";
        return template.query(sql, new BeanPropertyRowMapper<Role>(Role.class), userId);
    }
}

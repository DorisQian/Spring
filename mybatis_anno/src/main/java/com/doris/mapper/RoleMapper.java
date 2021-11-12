package com.doris.mapper;

import com.doris.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    @Select("select * from sys_user_role ur, sys_role r where ur.roleId=r.id and ur.userId=#{id}")
    public List<Role> findByUid(int id);
}

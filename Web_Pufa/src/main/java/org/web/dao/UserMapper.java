package org.web.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.web.entity.User;

public interface UserMapper {
    @Select("select * from admin where username = #{user} and password = #{password}")
    User getUser(@Param("username") String username, @Param("password") String password);
}

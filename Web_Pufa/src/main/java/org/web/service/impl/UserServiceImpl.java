package org.web.service.impl;

import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.web.dao.UserMapper;
import org.web.entity.User;
import org.web.service.UserService;
import org.web.utils.MybatisUtil;

public class UserServiceImpl implements UserService {
    @Override
    public boolean auth(String username, String password, HttpSession session) {

        try (SqlSession sqlSession = MybatisUtil.getSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUser(username, password);
            if (user == null) return false;
            session.setAttribute("user", user);
            return true;
        }
    }
}

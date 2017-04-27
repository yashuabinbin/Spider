package com.example.service;

import com.example.dao.UserMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * Created by lbb on 2017/4/22.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public List<User> list() {
        return userMapper.selectAll();
    }


    /**
     * 检测登录参数
     *
     * @param username
     * @param password
     * @return
     */
    public User checkLogin(String username, String password) {
        //md5加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = userMapper.selectUserByUserNameAndPassword(username, password);
        return user;
    }
}
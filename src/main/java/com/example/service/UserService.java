package com.example.service;

import com.example.dao.UserMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

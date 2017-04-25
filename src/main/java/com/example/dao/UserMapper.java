package com.example.dao;

import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    void insert(User user);

    List<User> selectAll();

    User selectUserByUserNameAndPassword(@Param("username") String username, @Param("password") String password);
}
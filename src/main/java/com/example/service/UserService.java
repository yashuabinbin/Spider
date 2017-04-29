package com.example.service;

import com.example.dao.UserMapper;
import com.example.dto.CommonResult;
import com.example.enums.CommonEnum;
import com.example.model.User;
import com.example.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
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


    /**
     * 用户名是否存在
     *
     * @param username
     * @return
     */
    public boolean isUsernameExist(String username) {
        User user = userMapper.selectUserByUserName(username);
        return user != null;
    }


    /**
     * 保存用户对象
     *
     * @param user
     * @param session
     * @return
     */
    public CommonResult saveUser(User user, HttpSession session) {
        if (isUsernameExist(user.getUsername())) {
            return new CommonResult(CommonEnum.Register_UserName_Exist);
        }

        //插入数据库
        userMapper.insertUser(user);

        //将用户对象放置到Session中
        session.setAttribute(Constant.LOGINED_USER, user);

        return new CommonResult(CommonEnum.Common_Success);
    }
}
package com.example.controller;

import com.example.dto.CommonResult;
import com.example.model.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by lbb on 2017/4/29.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;


    @PostMapping(value = "/register")
    @ResponseBody
    public CommonResult register(@RequestParam(value = "username", required = true) String username,
                                 @RequestParam(value = "password", required = true) String password,
                                 @RequestParam(value = "realname", required = true) String realname,
                                 @RequestParam(value = "email", required = true) String email,
                                 @RequestParam(value = "sex", required = true) Integer sex,
                                 HttpSession session) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        user.setEmail(email);
        user.setRealname(realname);
        user.setSex(sex);
        CommonResult result = userService.saveUser(user, session);
        return result;
    }


    @PostMapping(value = "/{email}/sendPwdEmail")
    @ResponseBody
    public CommonResult sendPwdEmail(@PathVariable(value = "email", required = true) String email) {
        return userService.sendPwdEmail(email);
    }
}

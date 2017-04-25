package com.example.controller;

import com.example.dto.ViewResult;
import com.example.enums.CommonEnum;
import com.example.model.User;
import com.example.service.UserService;
import com.example.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lbb on 2017/4/23.
 */
@Controller
public class IndexController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserService userService;


    /**
     * 跳转登陆界面
     *
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String login(HttpServletRequest request) {
        if (User.getLoginedUser(request) != null) {
            return "redirect:index";
        } else {
            return "login";
        }
    }


    /**
     * 检查登录
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @PostMapping(value = "/checkLogin")
    @ResponseBody
    public ViewResult checkLogin(@RequestParam(value = "username", required = true) String username,
                                 @RequestParam(value = "password", required = true) String password,
                                 HttpSession session) {
        if (StringUtils.isEmpty(username)) {
            return new ViewResult(CommonEnum.Login_UserName_Null);
        }

        if (StringUtils.isEmpty(password)) {
            return new ViewResult(CommonEnum.Login_Password_Null);
        }

        User user = userService.checkLogin(username, password);
        if (user != null) {
            session.setAttribute(Constant.LOGINED_USER, user);
            logger.info("loginUser:{}", user);
            return new ViewResult(CommonEnum.Login_Success);
        } else {
            return new ViewResult(CommonEnum.Login_UserNameOrPassword_Error);
        }
    }


    /**
     * 跳转index界面
     *
     * @return
     */
    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }
}

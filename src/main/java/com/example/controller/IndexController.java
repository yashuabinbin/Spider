package com.example.controller;

import com.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lbb on 2017/4/23.
 */
@Controller
public class IndexController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);


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
     * 跳转index界面
     *
     * @return
     */
    @GetMapping(value = "index")
    public String index(HttpSession session) {
        return "index";
    }
}

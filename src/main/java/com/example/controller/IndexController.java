package com.example.controller;

import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }


    /**
     * 跳转index界面
     *
     * @return
     */
    @GetMapping(value = {"/"})
    public String index() {
        return "index";
    }

}

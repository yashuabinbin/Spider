package com.example.controller;

import com.example.dto.CommonResult;
import com.example.enums.CommonEnum;
import com.example.model.User;
import com.example.service.UserService;
import com.example.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    /**
     * 注册
     *
     * @param username
     * @param password
     * @param realname
     * @param email
     * @param sex
     * @param session
     * @return
     */
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


    /**
     * 发送重置密码邮件
     *
     * @param email
     * @return
     */
    @PostMapping(value = "/{email}/sendPwdEmail")
    @ResponseBody
    public CommonResult sendPwdEmail(@PathVariable(value = "email", required = true) String email) {
        return userService.sendPwdEmail(email);
    }


    /**
     * 跳转重置密码页面
     *
     * @param email
     * @param code
     * @param model
     * @return
     */
    @GetMapping(value = "/{email}/toResetPwd")
    public String toResetPwd(@PathVariable(value = "email", required = true) String email,
                             @RequestParam(value = "code", required = true) String code,
                             HttpSession session, Model model) {
        //验证重制密码链接是否正确
        CommonResult result = userService.verifyMail(email, code);
        if (result.isSuccess()) {
            //将用户放入session中
            session.setAttribute(Constant.RESET_PWD_USER, result.getData("user"));
            return "resetPwd";
        } else {
            model.addAttribute("errorMsg", result.getStateInfo());
            return "error";
        }
    }


    /**
     * 重置密码
     *
     * @param password
     * @param session
     * @return
     */
    @PostMapping(value = "/resetPwd")
    @ResponseBody
    public CommonResult resetPwd(@RequestParam(value = "password", required = true) String password,
                                 HttpSession session) {
        User user = (User) session.getAttribute(Constant.RESET_PWD_USER);
        if (user == null) {
            return new CommonResult(CommonEnum.ResetPwd_Fail);
        }

        userService.resetPassword(user, password);
        return new CommonResult(CommonEnum.ResetPwd_Success);
    }
}

package com.example.service;

import com.example.dao.MailMapper;
import com.example.dao.UserMapper;
import com.example.dto.CommonResult;
import com.example.enums.CommonEnum;
import com.example.model.Mail;
import com.example.model.User;
import com.example.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * Created by lbb on 2017/4/22.
 */
@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MailMapper mailMapper;
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String Sender;
    @Value("${web.url}")
    private String webUrl;


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
        if (isEmailExist(user.getEmail())) {
            return new CommonResult(CommonEnum.Register_Email_Exist);
        }

        //插入数据库
        userMapper.insertUser(user);

        //将用户对象放置到Session中
        session.setAttribute(Constant.LOGINED_USER, user);

        return new CommonResult(CommonEnum.Common_Success);
    }


    /**
     * 发送找回密码邮件
     *
     * @param email
     */
    public CommonResult sendPwdEmail(String email) {
        try {
            String code = UUID.randomUUID().toString().replace("-", "");

            //生成找回密码url
            User user = userMapper.selectUserByEmail(email);
            if (user == null) {
                return new CommonResult(CommonEnum.Pwd_Email_NotExist);
            }

            String url = webUrl + "/toResetPwd/" + user.getEmail() + "/" + code;

            //插入ps_mail表
            Mail mail = new Mail();
            mail.setUid(user.getId());
            mail.setCode(code);
            mailMapper.insert(mail);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(Sender);
            message.setTo(email);
            message.setSubject("Spider 找回密码");

            //拼凑文件内容
            StringBuffer sb = new StringBuffer();
            sb.append("本邮件用于密码的找回，请勿回复<br/>");
            sb.append("<a href=\"" + url + "\">点击我进入重设密码页面</a>");
            sb.append("本邮件超过30分钟，链接将会失效，需要重新申请！");
            message.setText(sb.toString());

            //发送邮件
            new Thread(() -> javaMailSender.send(message)).start();

            return new CommonResult(CommonEnum.Common_Success);
        } catch (Exception e) {
            logger.error("发送找回密码邮件出错", e);
            return new CommonResult(CommonEnum.Common_Fail);
        }
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
     * 邮箱是否存在
     *
     * @param email
     * @return
     */
    public boolean isEmailExist(String email) {
        User user = userMapper.selectUserByEmail(email);
        return user != null;
    }
}
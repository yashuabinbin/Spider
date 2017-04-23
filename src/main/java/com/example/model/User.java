package com.example.model;

import com.example.utils.Constant;
import org.apache.ibatis.type.Alias;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Alias(value = "User")
public class User {

    private Integer id;

    private String username;

    private String password;

    private String realname;

    private String email;

    private Byte sex;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", createTime=" + createTime +
                '}';
    }


    /**
     * 从Session中获取已经登录的用户信息
     *
     * @param request
     * @return
     */
    public static User getLoginedUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(Constant.LOGINED_USER);
    }
}
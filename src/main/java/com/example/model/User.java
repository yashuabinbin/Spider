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

    private Integer sex;

    private Date createTime;

    private Date updateTime;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
                ", updateTime=" + updateTime +
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
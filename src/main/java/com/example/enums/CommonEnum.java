package com.example.enums;

/**
 * Created by lbb on 2017/4/25.
 */
public enum CommonEnum {

    Common_Success(0, "成功"),
    Common_Fail(-999, "错误"),

    Login_UserName_Null(-1, "请输入用户名"),
    Login_Password_Null(-2, "请输入密码"),
    Login_UserNameOrPassword_Error(-3, "用户名或密码错误"),

    Register_UserName_Exist(-4, "用户名已存在"),
    Register_Email_Exist(-5, "邮箱已存在"),

    Pwd_Email_NotExist(-6, "该邮箱未注册"),
    Pwd_Email_OutDate(-7, "邮件过期");

    private int state;

    private String stateInfo;

    CommonEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}

package com.example.utils;

import org.springframework.util.DigestUtils;

/**
 * Created by lbb on 2017/5/2.
 */
public class SignUtils {

    /**
     * 生成找回密码的sign
     *
     * @param email
     * @param nowTime
     * @param code
     * @return
     */
    public static String generatePwdSign(String email, long nowTime, String code) {
        return DigestUtils.md5DigestAsHex(("email=" + email + "&nowTime=" + nowTime + "&code").getBytes());
    }

}

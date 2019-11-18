package com.lmgy.qrcodelogin.util;

import org.springframework.util.DigestUtils;

/**
 * @author lmgy
 * @date 2019/11/18
 */
public class MD5Util {

    public static String md5(String t) {
        return DigestUtils.md5DigestAsHex(t.getBytes());
    }

    private static final String salt = "6iwn57fae12";

    public static String inputPassToFormPass(String pass) {
        String s = "" + salt.charAt(0) + salt.charAt(2) + salt.charAt(5) + pass + salt.charAt(7) + salt.charAt(8);
        return md5(s);
    }

    public static String formPassToDb(String formPass, String salt) {
        String s = "" + salt.charAt(0) + salt.charAt(2) + salt.charAt(5) + formPass + salt.charAt(7) + salt.charAt(8);
        return md5(s);
    }

    public static String inputPassToDbPass(String input, String salt) {
        String form = inputPassToFormPass(input);
        return formPassToDb(form, salt);
    }

}

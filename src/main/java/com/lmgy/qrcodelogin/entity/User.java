package com.lmgy.qrcodelogin.entity;

import lombok.Data;

/**
 * @author lmgy
 * @date 2019/11/15
 */
@Data
public class User {

    private long userId;
    private String userPassword;
    private String userName;
    private String userAvatar;
    private long userPhone;

}

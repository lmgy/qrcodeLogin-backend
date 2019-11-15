package com.lmgy.qrcodelogin.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author lmgy
 * @date 2019/11/15
 */
@Data
public class Auth {

    private String authToken;
    private Timestamp authTime;
    private String authIp;
    private String authAddress;
    private Integer authState;
    private long userId;

}

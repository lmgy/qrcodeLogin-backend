package com.lmgy.qrcodelogin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmgy
 * @date 2019/11/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private int code;
    private String message;
    private Object data;

}

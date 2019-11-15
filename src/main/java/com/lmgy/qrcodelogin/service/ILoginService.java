package com.lmgy.qrcodelogin.service;

import com.lmgy.qrcodelogin.entity.Message;

/**
 * @author lmgy
 * @date 2019/11/15
 */
public interface ILoginService {

    Message checkPassword(String userId, String userPassword);

    Message getUserInfo(String userId);

}

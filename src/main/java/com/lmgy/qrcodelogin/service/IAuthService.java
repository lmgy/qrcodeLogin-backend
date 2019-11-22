package com.lmgy.qrcodelogin.service;

import com.lmgy.qrcodelogin.entity.Message;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lmgy
 * @date 2019/11/15
 */
public interface IAuthService {

    Message addAuthInfo(HttpServletRequest request);

    Message getAuthInfo(String authToken, String userId, boolean isScan);

    Message setAuthState(String authToken, String userId);

    Message cancelAuth(String authToken, String userId);

}

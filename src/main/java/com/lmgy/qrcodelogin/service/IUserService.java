package com.lmgy.qrcodelogin.service;

import com.lmgy.qrcodelogin.entity.Message;

/**
 * @author lmgy
 * @date 2019/11/16
 */
public interface IUserService {

    Message changePassword(String userId, String newPassword);

    Message changeAvatar(String userId, String avatarLink);

}

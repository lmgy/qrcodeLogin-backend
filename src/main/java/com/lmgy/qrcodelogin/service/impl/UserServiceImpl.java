package com.lmgy.qrcodelogin.service.impl;

import com.lmgy.qrcodelogin.entity.Message;
import com.lmgy.qrcodelogin.repository.UserRepository;
import com.lmgy.qrcodelogin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lmgy
 * @date 2019/11/16
 */
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Message changePassword(String userId, String newPassword) {
        return null;
    }

    @Override
    public Message changeAvatar(String userId, String avatarLink) {
        return null;
    }

}

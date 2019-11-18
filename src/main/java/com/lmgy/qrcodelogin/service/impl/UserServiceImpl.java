package com.lmgy.qrcodelogin.service.impl;

import com.lmgy.qrcodelogin.entity.Message;
import com.lmgy.qrcodelogin.entity.User;
import com.lmgy.qrcodelogin.repository.UserRepository;
import com.lmgy.qrcodelogin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lmgy
 * @date 2019/11/16
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Message changePassword(String userId, String newPassword) {
        User user = userRepository.getUserByUserId(userId);
        user.setUserPassword(newPassword);
        userRepository.saveAndFlush(user);
        return new Message(200, "修改成功", user);
    }

    @Override
    public Message changeAvatar(String userId, String avatarLink) {
        User user = userRepository.getUserByUserId(userId);
        user.setUserAvatar(avatarLink);
        userRepository.saveAndFlush(user);
        return new Message(200, "修改成功", user);
    }

    @Override
    public Message registerUser(User user) {
        User ret = userRepository.save(user);
        return new Message(200, "注册成功", ret);
    }

}

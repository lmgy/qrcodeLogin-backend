package com.lmgy.qrcodelogin.service.impl;

import com.lmgy.qrcodelogin.entity.Message;
import com.lmgy.qrcodelogin.entity.User;
import com.lmgy.qrcodelogin.repository.UserRepository;
import com.lmgy.qrcodelogin.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lmgy
 * @date 2019/11/15
 */
@Service
@Slf4j
public class LoginServiceImpl implements ILoginService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Message checkPassword(String userId, String userPassword) {
        User user = userRepository.getUserByUserId(userId);
        log.info("user = " + user.getUserPassword());
        if (null == userPassword) {
            return new Message(201, "登录失败", new User());
        }
        if (!userPassword.equals(user.getUserPassword())) {
            return new Message(203, "登录失败", new User());
        }
        return new Message(200, "登录成功", user);
    }

    @Override
    public Message getUserInfo(String userId) {
        User user = userRepository.getUserByUserId(userId);
        log.info("user = " + user.getUserPassword());
        return new Message(200, "获取用户信息成功", user);
    }

}

package com.lmgy.qrcodelogin.controller;

import com.lmgy.qrcodelogin.entity.Message;
import com.lmgy.qrcodelogin.entity.User;
import com.lmgy.qrcodelogin.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author lmgy
 * @date 2019/11/16
 */
@Controller
@Slf4j
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    IUserService userService;

    @RequestMapping(value = "changePwd")
    @ResponseBody
    public Message changePassword(String userId, String newPassword) {
        return userService.changePassword(userId, newPassword);
    }

    @RequestMapping(value = "changeAvatar")
    @ResponseBody
    public Message changeAvatar(String userId, String avatarLink) {
        return userService.changeAvatar(userId, avatarLink);
    }


    @PostMapping(value = "reg")
    @ResponseBody
    public Message registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

}

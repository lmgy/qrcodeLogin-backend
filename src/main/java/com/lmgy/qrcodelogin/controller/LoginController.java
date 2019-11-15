package com.lmgy.qrcodelogin.controller;

import com.lmgy.qrcodelogin.entity.Message;
import com.lmgy.qrcodelogin.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author lmgy
 * @date 2019/11/15
 */
@Controller
@Slf4j
@RequestMapping(value = "/login")
public class LoginController {

    @Resource
    ILoginService loginService;

    // 登录，成功返回用户信息
    @RequestMapping(value = "")
    @ResponseBody
    public Message loginById(String userId, String userPassword) {
        log.info("userId" + userId);
        log.info("pwd" + userPassword);
        return loginService.checkPassword(userId, userPassword);
    }

    // 获取用户信息
    @RequestMapping(value = "getUser")
    @ResponseBody
    public Message getUserInfo(String userId) {
        return loginService.getUserInfo(userId);
    }

}

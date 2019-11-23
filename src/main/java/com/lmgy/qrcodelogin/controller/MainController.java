package com.lmgy.qrcodelogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lmgy
 * @date 2019/11/15
 */
@Controller
@RequestMapping("")
public class MainController {

    @RequestMapping(value = "")
    @ResponseBody
    public String main() {
        return "test";
    }

}

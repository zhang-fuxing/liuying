package com.zn.liuying.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/13
 * @email zhangfuxing1010@163.com
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/login/{userId}")
    public String login(@PathVariable("userId") Long userId) {
        StpUtil.login(userId);
        return "success";
    }

    @GetMapping("/isLogin")
    public String isLogin() {
        return "登录状态：" + StpUtil.isLogin();
    }
}

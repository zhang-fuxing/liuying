package com.zn.liuying;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.zn.liuying.build.Builder;
import com.zn.liuying.model.dto.LoginCredentials;
import com.zn.liuying.model.emtity.UserInfo;
import com.zn.liuying.model.enums.LoginMethod;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/13
 * @email zhangfuxing1010@163.com
 */
public class UserServiceImpl implements UserService {


    @Override
    public Object login(LoginCredentials credentials) {
        String captcha = credentials.getCaptcha();
        // 验证码校验

        // 根据登录方式获取数据库用户
        UserInfo userInfo = getUserInfo(credentials);
        // 和前端的信息对比 密码

        // 如果验证通过，则登录
        StpUtil.login(userInfo.getUserId());
        return SaResult.ok();
    }

    @Override
    public Object logout() {
        StpUtil.checkLogin();
        StpUtil.logout();
        return SaResult.ok();
    }

    @Override
    public Object isLogin() {
        return SaResult.ok(String.valueOf(StpUtil.isLogin()));
    }


    private UserInfo getUserInfo(LoginCredentials credentials) {
        LoginMethod method = credentials.getMethod();
        return switch (method) {
            case EMAIL -> Builder.create(UserInfo.class)
                    .setter(UserInfo::setEmail, credentials.getEmail())
                    .build();
            case PHONE -> Builder.create(UserInfo.class)
                    .setter(UserInfo::setPhoneNumber, credentials.getPhoneNumber())
                    .build();
            case ACCOUNT -> Builder.create(UserInfo.class)
                    .setter(UserInfo::setUsername, credentials.getUsername())
                    .setter(UserInfo::setPassword, credentials.getPassword())
                    .build();
        };
    }
}

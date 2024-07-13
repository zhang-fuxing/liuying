package com.zn.liuying;

import com.zn.liuying.model.dto.LoginCredentials;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/13
 * @email zhangfuxing1010@163.com
 */
public interface UserService {

    Object login(LoginCredentials credentials);

    Object logout();

    Object isLogin();


}

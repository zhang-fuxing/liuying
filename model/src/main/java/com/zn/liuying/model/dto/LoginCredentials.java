package com.zn.liuying.model.dto;

import com.zn.liuying.model.enums.LoginMethod;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/13
 * @email zhangfuxing1010@163.com
 */
public class LoginCredentials {
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
    private String captcha;
    private String loginCode;
    private LoginMethod method = LoginMethod.ACCOUNT;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public LoginMethod getMethod() {
        return method;
    }

    public void setMethod(LoginMethod method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "LoginCredentials{" +
               "phoneNumber='" + phoneNumber + '\'' +
               ", email='" + email + '\'' +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", captcha='" + captcha + '\'' +
               ", loginCode='" + loginCode + '\'' +
               ", method=" + method +
               '}';
    }
}

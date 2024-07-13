package com.z.liuying;

/**
 * 指定模板单发
 *
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/13
 * @email zhangfuxing1010@163.com
 */
@SuppressWarnings("SpellCheckingInspection")
public class SmsInfo {
    private String clientid;
    private String password;
    private String templateid;
    private String param;
    private String mobile;
    private String uid;

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "VariableSms{" +
               "clientid='" + clientid + '\'' +
               ", password='" + password + '\'' +
               ", templateid='" + templateid + '\'' +
               ", param='" + param + '\'' +
               ", mobile='" + mobile + '\'' +
               ", uid='" + uid + '\'' +
               '}';
    }
}

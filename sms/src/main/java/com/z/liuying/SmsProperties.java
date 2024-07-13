package com.z.liuying;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/13
 * @email zhangfuxing1010@163.com
 */
@ConfigurationProperties("sms")
public class SmsProperties {
    private String onceUrl;
    private String multipleUrl;
    private String addTemplate;

    public String getAddTemplate() {
        return addTemplate;
    }

    public void setAddTemplate(String addTemplate) {
        this.addTemplate = addTemplate;
    }

    public String getOnceUrl() {
        return onceUrl;
    }

    public void setOnceUrl(String onceUrl) {
        this.onceUrl = onceUrl;
    }

    public String getMultipleUrl() {
        return multipleUrl;
    }

    public void setMultipleUrl(String multipleUrl) {
        this.multipleUrl = multipleUrl;
    }
}

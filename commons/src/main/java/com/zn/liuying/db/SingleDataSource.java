package com.zn.liuying.db;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/6/30
 * @email zhangfuxing1010@163.com
 */
@ConfigurationProperties("spring.datasource.single")
public class SingleDataSource {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private Class<? extends DataSource> type;

    @PostConstruct
    public void init() {
        DSOption.context.put("primary", "single");
    }

    public boolean isAvailable() {
        return driverClassName != null && url != null && username != null;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Class<? extends DataSource> getType() {
        return type;
    }

    public void setType(Class<? extends DataSource> type) {
        this.type = type;
    }
}

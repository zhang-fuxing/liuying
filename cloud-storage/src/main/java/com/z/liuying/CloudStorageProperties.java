package com.z.liuying;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/13
 * @email zhangfuxing1010@163.com
 */
@ConfigurationProperties("cloud-storage")
public class CloudStorageProperties {
    @ConfAlias("serverName")
    private String endpoint;
    @ConfAlias("username")
    private String accessKey = "zhangfx";
    @ConfAlias("password")
    private String secretKey = "XIloJtC5kgkiujMH1VVgSwXRDKXRbSBu";

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setServerName(String serverName) {
        this.endpoint = serverName;
    }
    public String getServerName() {
        return endpoint;
    }

    public String getUsername() {
        return accessKey;
    }

    public void setUsername(String username) {
        this.accessKey = username;
    }

    public String getPassword() {
        return secretKey;
    }
    public void setPassword(String password) {
        this.secretKey = password;
    }
}

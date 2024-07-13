package com.z.liuying;

import com.upyun.RestManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * zhangfx
 * XIloJtC5kgkiujMH1VVgSwXRDKXRbSBu
 *
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/13
 * @email zhangfuxing1010@163.com
 */
@EnableConfigurationProperties(CloudStorageProperties.class)
public class CloudStorage {

    @Autowired
    CloudStorageProperties cloudStorageProperties;

    @Bean
    public RestManager restManager() {
        RestManager restManager = new RestManager(cloudStorageProperties.getEndpoint(),
                cloudStorageProperties.getAccessKey(),
                cloudStorageProperties.getSecretKey());
        restManager.setApiDomain(RestManager.ED_AUTO);
        return restManager;
    }
}

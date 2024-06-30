package com.zn.kcms.db;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/6/28
 * @email zhangfuxing1010@163.com
 */
@Configuration
public class DataSourceProvide implements TransactionManagementConfigurer {

    @Bean
    @ConfigurationProperties("spring.druid")
    public DynamicDataSource dynamicDataSource(DruidStatProperties properties) {
        System.out.println(properties);
        return new DynamicDataSource();
    }

    @Override
    public TransactionManager annotationDrivenTransactionManager() {
        return null;
    }
}

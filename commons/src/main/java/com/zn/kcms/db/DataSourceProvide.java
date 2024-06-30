package com.zn.kcms.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/6/28
 * @email zhangfuxing1010@163.com
 */
@Configuration
@EnableConfigurationProperties({DataSourceProperties.class, SingleDataSource.class, MultipleDataSource.class})
public class DataSourceProvide implements TransactionManagementConfigurer {

    @Autowired
    SingleDataSource singleDataSource;
    @Autowired
    MultipleDataSource multipleDataSource;

    @Bean
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = buildTargetDataSources();
        dynamicDataSource.setTargetDataSources(targetDataSources);
        if (multipleDataSource.isAvailable()) {
            String primary = DSOption.context.get("primary");
            dynamicDataSource.setDefaultTargetDataSource(targetDataSources.get(primary));
        } else {
            dynamicDataSource.setDefaultTargetDataSource(targetDataSources.get("primary"));
        }
        return dynamicDataSource;
    }

    @Bean
    @Override
    @SuppressWarnings("NullableProblems")
    public TransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

    private Map<Object, Object> buildTargetDataSources() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        if (!singleDataSource.isAvailable() && !multipleDataSource.isAvailable()) {
            var dataSource = defaultDataSource();
            targetDataSources.put("primary", dataSource);
        }
        if (singleDataSource.isAvailable()) {
            var dataSource = buildDataSource(singleDataSource);
            targetDataSources.put("primary", dataSource);
        }
        if (multipleDataSource.isAvailable()) {
            for (var singleConf : multipleDataSource.getConfigs().entrySet()) {
                if (singleConf == null || singleConf.getValue() == null || !singleConf.getValue().isAvailable())
                    continue;
                var dataSourceConfig = singleConf.getValue();
                String keyName = singleConf.getKey();
                var dataSource = buildDataSource(dataSourceConfig);
                targetDataSources.put(keyName, dataSource);
            }
        }
        return targetDataSources;
    }

    private DruidDataSource buildDataSource(SingleDataSource singleDataSource) {
        return DataSourceBuilder.create()
                .type(DruidDataSource.class)
                .driverClassName(singleDataSource.getDriverClassName())
                .url(singleDataSource.getUrl())
                .username(singleDataSource.getUsername())
                .password(singleDataSource.getPassword())
                .build();
    }

    private DruidDataSource defaultDataSource() {
        return DataSourceBuilder.create()
                .type(DruidDataSource.class)
                .build();
    }
}

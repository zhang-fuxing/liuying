package com.zn.liuying.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用动态数据源时，应用数据源的提供者配置类，想要在启动类上使用 @Import(DataSourceProvide.class) 加载该类
 * <p>
 * 才能正确的使用动态数据源，该动态数据源由自己实现，目前未实现其他数据源的特性
 *
 * @author 张福兴
 * @version 1.0
 * @date 2024/6/28
 * @email zhangfuxing1010@163.com
 */
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

    private DataSource buildDataSource(SingleDataSource singleDataSource) {
        DataSourceBuilder<?> builder = DataSourceBuilder.create()
                .driverClassName(singleDataSource.getDriverClassName())
                .url(singleDataSource.getUrl())
                .username(singleDataSource.getUsername())
                .password(singleDataSource.getPassword());

        Class<? extends DataSource> type = singleDataSource.getType();
        //noinspection ReplaceNullCheck
        if (type != null) {
            builder.type(type);
        } else {
            builder.type(DruidDataSource.class);
        }
        return builder.build();
    }

    private DruidDataSource defaultDataSource() {
        return DataSourceBuilder.create()
                .type(DruidDataSource.class)
                .build();
    }
}

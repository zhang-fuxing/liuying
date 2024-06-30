package com.zn.kcms.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 单个
 *
 * @author 张福兴
 * @version 1.0
 * @date 2024/6/30
 * @email zhangfuxing1010@163.com
 */
@ConfigurationProperties("spring.datasource.multiple")
public class MultipleDataSource {
    private static final Logger log = LoggerFactory.getLogger(MultipleDataSource.class);
    private String primary;
    private Map<String, SingleDataSource> configs;

    @PostConstruct
    public void init() {
        if (configs == null || configs.isEmpty()) return;
        if (StringUtils.hasText(this.primary) && configs.containsKey(this.primary)) {
            DSOption.context.put("primary", primary);
        }
        int count = 1;
        for (var entry : configs.entrySet()) {
            String key = entry.getKey();
            SingleDataSource singleDataSource = entry.getValue();
            if (singleDataSource.isAvailable() && !DSOption.context.containsValue(key)) {
                DSOption.context.putIfAbsent("slave_" + (count++), key);
            }
        }
    }

    public boolean isAvailable() {
        if (configs == null || configs.isEmpty()) {
            return false;
        }
        List<String> keyName = new ArrayList<>();
        for (var item : configs.entrySet()) {
            if (!item.getValue().isAvailable()) {
                log.warn("数据源：{} 无效，将无法正常使用该数据源", item.getKey());
                configs.remove(item.getKey());
            }
            keyName.add(item.getKey());
        }
        if (configs == null || configs.isEmpty()) {
            return false;
        }
        if (primary != null && !primary.isBlank() && !configs.containsKey(primary)) {
            log.warn("没有配置主要数据源：{}， 配置中的第一个数据源：{} 将成为主要数据源。", primary, keyName.get(0));
        }
        if (primary == null || primary.isBlank()) {
            log.warn("未指定主要数据源：spring.datasource.multiple.primary: ,{} 将成为主要数据源", keyName.get(0));
        }
        return true;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public Map<String, SingleDataSource> getConfigs() {
        return configs;
    }

    public void setConfigs(Map<String, SingleDataSource> configs) {
        this.configs = configs;
    }


}

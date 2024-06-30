package com.zn.kcms;

import com.zn.kcms.db.DataSourceProvide;
import com.zn.kcms.db.DynamicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/06/24
 * @email zhangfuxing1010@163.com
 */
@SpringBootApplication(scanBasePackages = "com.zn.kcms")
@MapperScan("com.zn.kcms.repository")
public class ApplicationStarter {
    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationStarter.class, args);
        var bean = context.getBean(DataSourceProvide.class);
        var bean1 = context.getBean(DynamicDataSource.class);
        System.out.println("http://127.0.0.1:8088/");
    }
}

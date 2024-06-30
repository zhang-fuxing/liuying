package com.zn.kcms;

import com.zn.kcms.db.DataSourceProvide;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/06/24
 * @email zhangfuxing1010@163.com
 */
@SpringBootApplication(scanBasePackages = "com.zn.kcms")
@Import(DataSourceProvide.class)
@MapperScan("com.zn.kcms.repository")
public class ApplicationStarter {
    private static final Logger log = LoggerFactory.getLogger(ApplicationStarter.class);

    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationStarter.class, args);
        log.info("启动成功，项目访问地址: http://127.0.0.1:8088/");
    }
}

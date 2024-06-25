package com.zn.starter;

import com.zn.model.emtity.TestTab;
import com.zn.repository.TestTabMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/06/24
 * @email zhangfuxing1010@163.com
 */
@SpringBootApplication(scanBasePackages = "com.zn")
@MapperScan("com.zn.repository")
public class ApplicationStarter {
    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationStarter.class, args);
        var contextBean = context.getBean(TestTabMapper.class);
        TestTab entity = new TestTab();
        entity.setContent("test");
        entity.setCtime("now");
        contextBean.insert(entity);
    }
}

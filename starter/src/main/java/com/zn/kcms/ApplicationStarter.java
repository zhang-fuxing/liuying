package com.zn.kcms;

import com.zn.kcms.model.emtity.TestTab;
import com.zn.kcms.repository.TestTabMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/06/24
 * @email zhangfuxing1010@163.com
 */
@SpringBootApplication
@MapperScan("com.zn.kcms.repository")
public class ApplicationStarter {
    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationStarter.class, args);
        var contextBean = context.getBean(TestTabMapper.class);
        TestTab testTab = new TestTab();
        testTab.setContent("test content......");
        testTab.setCtime("now");
        testTab.setUtime("now ++");
        contextBean.insert(testTab);
    }
}

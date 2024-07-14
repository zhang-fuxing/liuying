package com.zn.liuying.freemarker;

import freemarker.template.TemplateExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/14
 * @email zhangfuxing1010@163.com
 */
@Configuration
public class FreeMarkerConfig {

    @Bean
    public freemarker.template.Configuration customizeFreeMarkerConfiguration(freemarker.template.Configuration cfg) {
        // 注册自定义指令
        cfg.setSharedVariable("ArticleList", new ArticleListDirective());
        // 其他配置...
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return cfg;
    }
}

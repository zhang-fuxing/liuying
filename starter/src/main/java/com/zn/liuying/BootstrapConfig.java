package com.zn.liuying;

import com.zn.liuying.app.StaticResource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/9/26
 * @email zhangfuxing1010@163.com
 */
@Configuration
@EnableConfigurationProperties(StaticResource.class)
public class BootstrapConfig implements WebMvcConfigurer {

    private final StaticResource staticResource;

    public BootstrapConfig(StaticResource staticResource) {
        this.staticResource = staticResource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    /**
     * 注册静态资源映射
     *
     * @param registry 注册器
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticResource.getStaticPathPattern()).addResourceLocations(staticResource.getStaticLocations());
    }
}

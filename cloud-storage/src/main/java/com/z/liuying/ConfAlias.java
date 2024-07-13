package com.z.liuying;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 为配置的字段起一个别名，没有其他含义
 *
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/13
 * @email zhangfuxing1010@163.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ConfAlias {
    String[] value() default {};
}

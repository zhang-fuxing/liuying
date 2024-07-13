package com.zn.liuying.build;

import cn.hutool.core.util.ReflectUtil;

import java.util.function.BiConsumer;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/13
 * @email zhangfuxing1010@163.com
 */
public class Builder<T> {
    private T target;
    private Builder() {
    }

    public static <T> Builder<T> create(Class<T> clazz) {
        Builder<T> builder = new Builder<>();
        builder.target = ReflectUtil.newInstance(clazz);
        return builder;
    }

    public <U> Builder<T> setter(BiConsumer<T, U> setter, U value) {
        setter.accept(target, value);
        return this;
    }
    public T build() {
        return target;
    }
}

package com.zn.kcms.db;


import java.util.HashMap;
import java.util.Map;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/6/28
 * @email zhangfuxing1010@163.com
 */
public class DSOption {
    public static final Map<String, String> context = new HashMap<>();
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static String getDs() {
        String dsKey = THREAD_LOCAL.get();
        return dsKey == null || dsKey.isBlank() ? "primary" : dsKey;
    }

    public static void setDs(String dsKey) {
        THREAD_LOCAL.set(dsKey);
    }

    public static void clean() {
        THREAD_LOCAL.remove();
    }
    public static void cleanAndSet(String dsKey) {
        clean();
        setDs(dsKey);
    }
}

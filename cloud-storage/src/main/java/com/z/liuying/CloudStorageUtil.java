package com.z.liuying;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/13
 * @email zhangfuxing1010@163.com
 */
public class CloudStorageUtil {
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    static SimpleDateFormat dateFormat = new SimpleDateFormat(
            "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    static {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public static Date convert(String gmtTimeStr) {
        try {
            return dateFormat.parse(gmtTimeStr);
        } catch (ParseException e) {
            throw new RuntimeException("GMT时间解析失败");
        }
    }

    public static String convert(Date date) {
        return dateFormat.format(date);
    }

    /**
     * 云存储服务计算md5值的方法
     *
     * @param string 需要进行MD5的字符串
     * @return MD5后的值 32位小写
     */
    public static String md5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MessageDigest不支持MD5Util", e);
        }
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    public static byte[] hashHmac(String data, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);
        return mac.doFinal(data.getBytes());
    }

    /**
     * 生成云存储调用的token字符串
     *
     * @param operator  操作员名称
     * @param password  操作员密码
     * @param method    请求的方法： PUT GET POST......
     * @param uri       资源路径
     * @param date      调用的时间
     * @param policy    ""
     * @param md5       ""
     * @return          token签名
     * @throws Exception 摘要生成失败时
     */
    public static String sign(String operator, String password, String method, String uri, String date, String policy,
                              String md5) throws Exception {
        String value = method + "&" + uri + "&" + date;
        if (!Objects.equals(policy, "")) {
            value = value + "&" + policy;
        }
        if (!Objects.equals(md5, "")) {
            value = value + "&" + md5;
        }
        byte[] hmac = hashHmac(value, password);
        String sign = Base64.getEncoder().encodeToString(hmac);
        return "UPYUN " + operator + ":" + sign;
    }

    public static String getRfc1123Time() {
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

}

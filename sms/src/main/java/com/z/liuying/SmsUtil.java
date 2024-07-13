package com.z.liuying;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;

import java.security.MessageDigest;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/13
 * @email zhangfuxing1010@163.com
 */
public class SmsUtil {
    public static String md5( String content){
        StringBuilder sb = new StringBuilder();
        try{
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bs = digest.digest(content.getBytes());
            /*
             *  加密后的数据是-128 到 127 之间的数字，这个数字也不安全。
             *   取出每个数组的某些二进制位进行某些运算，得到一个具体的加密结果
             *
             *   0000 0011 0000 0100 0010 0000 0110 0001
             *  &0000 0000 0000 0000 0000 0000 1111 1111
             *  ---------------------------------------------
             *   0000 0000 0000 0000 0000 0000 0110 0001
             *   把取出的数据转成十六进制数
             */
            for (byte b : bs) {
                int x = b & 255;
                String s = Integer.toHexString(x);
                if(x < 16){
                    sb.append("0");
                    sb.append(s);
                }else{
                    sb.append(s);
                }
            }
        }catch( Exception e){
            System.out.println("加密失败");
        }
        return sb.toString();
    }

    public static void send(String url, SmsInfo smsInfo) {
        try (HttpResponse execute = HttpRequest.post(url)
                .header("Content-Type", "application/json")
                .body(JSONUtil.toJsonStr(smsInfo))
                .execute()) {
            String body = execute.body();
            System.out.println(body);
        }
    }
}

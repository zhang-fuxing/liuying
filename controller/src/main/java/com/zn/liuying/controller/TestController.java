package com.zn.liuying.controller;

import com.upyun.RestManager;
import com.upyun.UpException;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/13
 * @email zhangfuxing1010@163.com
 */
@RestController
@RequestMapping("/test")
public class TestController {

    final RestManager restManager;

    public TestController(RestManager restManager) {
        this.restManager = restManager;
    }

    @GetMapping("/del")
    public String login() throws UpException, IOException {
        try (Response response = restManager.deleteFile("/", null)) {
            if (response.body() != null) {
                System.out.println(response.body().string());
            }
        }
        return "success";
    }

    @GetMapping("/dir")
    public String getDir() throws UpException, IOException {
        try (Response response = restManager.getFileInfo("/a0d4n-d27tr.jpg")) {
            String s = response.headers() + "";
            System.out.println(s);
            return s;
        }
    }

}

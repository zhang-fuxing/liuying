package com.zn.kcms.controller;

import com.zn.kcms.TestTabService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/06/24
 * @email zhangfuxing1010@163.com
 */
@Controller
public class IndexController {

    final TestTabService testTabService;

    public IndexController(TestTabService testTabService) {
        this.testTabService = testTabService;
    }

    @GetMapping("/")
    public String index(Map<String, Object> data) {
        data.put("name", "zhangfx");
        data.put("tabinfo", testTabService.getById(1));
        return "index";
    }

    @GetMapping("/test")
    public String test(@RequestParam("hex") String hex, Map<String, Object> data) {
        System.out.println(hex);
        data.put("imgName", "test");
        return "test";
    }
}

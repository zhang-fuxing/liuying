package com.zn.liuying.controller;

import com.zn.liuying.TestTabService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
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
        data.put("articles", List.of(1,2,3));
        data.put("dire", new HashMap<String, Object>());
        return "index";
    }

    @GetMapping("/getArticles")
    public List<?> getArticles() {
        return List.of(1,2,3);
    }

    @GetMapping("/test")
    public String test(@RequestParam("hex") String hex, Map<String, Object> data) {
        System.out.println(hex);
        data.put("imgName", "test");
        return "test";
    }

    @PostMapping("/postSubmit")
    public String postSubmit(@RequestBody Object args, Map<String, Object> data) {

        return null;
    }


}

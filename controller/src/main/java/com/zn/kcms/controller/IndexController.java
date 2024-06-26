package com.zn.kcms.controller;

import com.zn.kcms.model.emtity.TestTab;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/06/24
 * @email zhangfuxing1010@163.com
 */
@Controller
public class IndexController {

    @ResponseBody
    @GetMapping("/")
    public String index() {
        return "hello world";
    }

    @GetMapping("/init")
    public TestTab init() {
        TestTab entity = new TestTab();
        entity.setId(1);
        entity.setContent("test contest");
        entity.setContent("is time");
        entity.setUtime("u time");
        return entity;
    }
}

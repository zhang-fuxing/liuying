package com.zn.kcms.controller;

import com.zn.kcms.TestTabService;
import com.zn.kcms.db.DSOption;
import com.zn.kcms.model.emtity.TestTab;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/postSubmit")
    public String postSubmit(@RequestBody Object args, Map<String, Object> data) {

        return null;
    }

    @ResponseBody
    @GetMapping("/dm")
    public Object submitToDm() {
        DSOption.setDs("dameng");
        TestTab testTab = new TestTab();
        testTab.setContent("dameng content");
        TestTab save = testTabService.save(testTab);
        DSOption.clean();
        return save;
    }

    @ResponseBody
    @GetMapping("/mysql")
    public Object submitToMysql() {
        DSOption.setDs("mysql");
        TestTab testTab = new TestTab();
        testTab.setContent("mysql content");
        TestTab save = testTabService.save(testTab);
        DSOption.clean();
        return save;
    }
}

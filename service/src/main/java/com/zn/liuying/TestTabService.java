package com.zn.liuying;

import com.zn.liuying.model.emtity.TestTab;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/6/28
 * @email zhangfuxing1010@163.com
 */
public interface TestTabService {
    TestTab getById(Integer id);

    TestTab save(TestTab testTab);
}

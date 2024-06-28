package com.zn.kcms;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.zn.kcms.model.emtity.TestTab;
import com.zn.kcms.repository.TestTabMapper;
import org.springframework.stereotype.Service;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/6/28
 * @email zhangfuxing1010@163.com
 */
@Service
public class TestTabServiceImpl implements TestTabService {
    final TestTabMapper testTabMapper;

    public TestTabServiceImpl(TestTabMapper testTabMapper) {
        this.testTabMapper = testTabMapper;
    }

    @Override
    public TestTab getById(Integer id) {
        return new LambdaQueryChainWrapper<>(TestTab.class)
                .eq(TestTab::getId, 1)
                .one();
    }

}

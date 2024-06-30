package com.zn.kcms;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.zn.kcms.model.emtity.TestTab;
import com.zn.kcms.repository.TestTabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/6/28
 * @email zhangfuxing1010@163.com
 */
@Service
public class TestTabServiceImpl implements TestTabService {
    final TestTabMapper testTabMapper;
    TestTabService testTabService;

    public TestTabServiceImpl(TestTabMapper testTabMapper) {
        this.testTabMapper = testTabMapper;
    }

    /**
     * 当想要在同一个 service 中开启两个事物并从不同数据源中获取数据时，可以懒加载当前 bean 对象，然后调用其他方法进行获取
     *
     * @param testTabService service bean对象
     */
    @Lazy
    @Autowired
    public void setTestTabService(TestTabService testTabService) {
        this.testTabService = testTabService;
    }

    @Override
    public TestTab getById(Integer id) {
        return new LambdaQueryChainWrapper<>(TestTab.class)
                .eq(TestTab::getId, 1)
                .one();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TestTab save(TestTab testTab) {
        int insert = testTabMapper.insert(testTab);
        if (insert <= 0) throw new RuntimeException("插入失败");
        return testTab;
    }

}

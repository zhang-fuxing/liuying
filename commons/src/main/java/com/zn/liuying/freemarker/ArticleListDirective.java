package com.zn.liuying.freemarker;

import cn.hutool.core.convert.Convert;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/14
 * @email zhangfuxing1010@163.com
 */
public class ArticleListDirective implements TemplateDirectiveModel {

    /**
     * 自定义的指令解析器
     *
     * @param env      当前模板的环境变量
     * @param params   当前模板传递的参数列表
     * @param loopVars 当前模板的循环变量
     * @param body     模板指令的主体
     * @throws IOException       发生IO异常时
     * @throws TemplateException 模板解析异常时
     */
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws IOException, TemplateException {
        ArticleLisProp convert = Convert.convert(ArticleLisProp.class, params);
        loopVars[0] = env.getObjectWrapper().wrap(List.of("zhangfx", "kafka", "liuying", "jingliu"));
        body.render(env.getOut());
    }
}

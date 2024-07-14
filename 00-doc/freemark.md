### 使用spring boot3和 freemarker 实现自定义标签，并在模板中使用
0、 默认已经整合了springboot3和freemarker，即项目框架已经搭建完成

1、 实现 `freemarker.template.TemplateDirectiveModel` 接口后进行逻辑编写
```java
// 自定义标签的解析类
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
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
            throws IOException, TemplateException {
        // 使用Hutool工具类可以将模板参数转换为实体类，方便操作
        ArticleLisProp convert = Convert.convert(ArticleLisProp.class, params);
        // 可以根据循环变量，将数据包装后返回给模板渲染，可以是多个，具体需要根据标签进行设置
        // 可以在这里进行数据库查询，并将结果封装回去
        loopVars[0] = env.getObjectWrapper().wrap(List.of("zhangfx", "kafka", "liuying", "jingliu"));
        // 使用body渲染模板并输出
        body.render(env.getOut());
    }
}
```
2、 要想在模板中使用自定义标签，需要在free marker的配置类中使用共享变量注册标签
```java
// 可以使用多种方式，如 @PostConstruct 注解等，这里选择在配置类中进行处理
@Configuration
public class FreeMarkerConfig {

    // 自动注入freemarker的配置类，注册完标签后再将其返回，保证不覆盖原来的配置类
    @Bean
    public freemarker.template.Configuration customizeFreeMarkerConfiguration(freemarker.template.Configuration cfg) {
        // 注册自定义指令，ArticleList 是访问的标签名称， new ArticleListDirective() 是具体的实例化对象
        cfg.setSharedVariable("ArticleList", new ArticleListDirective());
        // cfg.setSharedVariable("other", new Other()); 可以注册更多
        // 其他配置...
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return cfg;
    }
}
```
3、 在模板中使用自定义标签
```ftl
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<div>
    <!-- 使用自定义标签 ，count=4 tip='true' 是传递给模板指令解析器的参数，list, map 是模板指令解析器封装的数据，如数据库数据等 -->
    <@ArticleList count=4 tip='true'; list, map >
        <!-- freemarker 的循环标签, 即使用 指令解析器返回的 list 数据进行循环创建 li 标签，开发人员可以方便的为 li 设置样式 -->
        <#list list as item>
            <li>${item}</li>
        </#list>
    </@ArticleList>
</div>
</body>
</html>
```
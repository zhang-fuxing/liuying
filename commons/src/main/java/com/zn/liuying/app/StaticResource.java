package com.zn.liuying.app;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/9/20
 * @email zhangfuxing1010@163.com
 */
@ConfigurationProperties("spring.static-resource")
public class StaticResource {
    private String siteEntryPoint = "index";
    private String searchResult = "search";
    private String[] staticLocations = {"classpath:static/", "classpath:META-INF/resources/", "classpath:/public/"};
    private String[] staticPathPattern = {"/**"};

    public String getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(String searchResult) {
        this.searchResult = searchResult;
    }

    public String getSiteEntryPoint() {
        return siteEntryPoint;
    }

    public void setSiteEntryPoint(String siteEntryPoint) {
        this.siteEntryPoint = siteEntryPoint;
    }

    public String[] getStaticLocations() {
        return staticLocations;
    }

    public void setStaticLocations(String[] staticLocations) {
        this.staticLocations = staticLocations;
    }

    public String[] getStaticPathPattern() {
        return staticPathPattern;
    }

    public void setStaticPathPattern(String[] staticPathPattern) {
        this.staticPathPattern = staticPathPattern;
    }
}

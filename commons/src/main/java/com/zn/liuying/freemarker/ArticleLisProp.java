package com.zn.liuying.freemarker;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/14
 * @email zhangfuxing1010@163.com
 */
public class ArticleLisProp {
    private String title;
    private String author;
    private String content;
    private String tip;
    private Integer count;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ArticleLisProp{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", content='" + content + '\'' +
               ", tip='" + tip + '\'' +
               ", count=" + count +
               '}';
    }
}

package com.zn.liuying.model.emtity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author 张福兴
 * @version 1.0
 * @date 2024/06/24
 * @email zhangfuxing1010@163.com
 */
@TableName
public class TestTab {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField
    private String content;
    @TableField
    private String ctime;
    @TableField
    private String utime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime;
    }

    @Override
    public String toString() {
        return "TestTab{" +
               "id=" + id +
               ", content='" + content + '\'' +
               ", ctime='" + ctime + '\'' +
               ", utime='" + utime + '\'' +
               '}';
    }
}

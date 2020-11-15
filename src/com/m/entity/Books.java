//实体类
package com.m.entity;

import java.util.Date;

public class Books {
    private Integer id;
    private String name;
    private String nather;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnther() {
        return nather;
    }

    public void setAnther(String nather) {
        this.nather = nather;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", anther='" + nather + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

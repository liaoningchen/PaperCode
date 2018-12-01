package com.examOnline.model;

import java.util.Date;

public class Practice {
    private Integer number;

    private String id;

    private String queslibid;

    private String object;

    private String state;

    private String cretaeBy;

    private Date createTime;

    private String other1;

    private String other2;

    private String other3;

    private String other4;

    private String other5;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getQueslibid() {
        return queslibid;
    }

    public void setQueslibid(String queslibid) {
        this.queslibid = queslibid == null ? null : queslibid.trim();
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object == null ? null : object.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCretaeBy() {
        return cretaeBy;
    }

    public void setCretaeBy(String cretaeBy) {
        this.cretaeBy = cretaeBy == null ? null : cretaeBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1 == null ? null : other1.trim();
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2 == null ? null : other2.trim();
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3 == null ? null : other3.trim();
    }

    public String getOther4() {
        return other4;
    }

    public void setOther4(String other4) {
        this.other4 = other4 == null ? null : other4.trim();
    }

    public String getOther5() {
        return other5;
    }

    public void setOther5(String other5) {
        this.other5 = other5 == null ? null : other5.trim();
    }
}
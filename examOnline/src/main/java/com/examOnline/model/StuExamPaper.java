package com.examOnline.model;

public class StuExamPaper {
    private String id;

    private String parcid;

    private String stuanswer;

    private String object;

    private String other1;

    private String other2;

    private String other3;

    private String other4;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParcid() {
        return parcid;
    }

    public void setParcid(String parcid) {
        this.parcid = parcid == null ? null : parcid.trim();
    }

    public String getStuanswer() {
        return stuanswer;
    }

    public void setStuanswer(String stuanswer) {
        this.stuanswer = stuanswer == null ? null : stuanswer.trim();
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object == null ? null : object.trim();
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
}
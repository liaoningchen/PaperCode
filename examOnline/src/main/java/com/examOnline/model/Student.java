package com.examOnline.model;

public class Student {
    private String id;

    private String name;

    private String sex;

    private String code;

    private String password;

    private String email;

    private String school;

    private String college;

    private String major;

    private String other1;

    private String other2;

    private String other3;

    private String other4;

    private String other5;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
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
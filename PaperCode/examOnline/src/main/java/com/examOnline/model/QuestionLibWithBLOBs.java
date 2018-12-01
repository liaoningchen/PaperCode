package com.examOnline.model;

public class QuestionLibWithBLOBs extends QuestionLib {
    private String question;

    private String answera;

    private String answerb;

    private String answerc;

    private String answerd;

    private String answere;

    private String answerf;

    private String detail;

    private String trueanswer;

    private String other4;

    private String other5;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswera() {
        return answera;
    }

    public void setAnswera(String answera) {
        this.answera = answera == null ? null : answera.trim();
    }

    public String getAnswerb() {
        return answerb;
    }

    public void setAnswerb(String answerb) {
        this.answerb = answerb == null ? null : answerb.trim();
    }

    public String getAnswerc() {
        return answerc;
    }

    public void setAnswerc(String answerc) {
        this.answerc = answerc == null ? null : answerc.trim();
    }

    public String getAnswerd() {
        return answerd;
    }

    public void setAnswerd(String answerd) {
        this.answerd = answerd == null ? null : answerd.trim();
    }

    public String getAnswere() {
        return answere;
    }

    public void setAnswere(String answere) {
        this.answere = answere == null ? null : answere.trim();
    }

    public String getAnswerf() {
        return answerf;
    }

    public void setAnswerf(String answerf) {
        this.answerf = answerf == null ? null : answerf.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getTrueanswer() {
        return trueanswer;
    }

    public void setTrueanswer(String trueanswer) {
        this.trueanswer = trueanswer == null ? null : trueanswer.trim();
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
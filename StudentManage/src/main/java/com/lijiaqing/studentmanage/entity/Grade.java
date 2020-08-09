package com.lijiaqing.studentmanage.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Grade {
    private String stu_id;
    private String cou_id;
    private String stu_name;
    private String cou_name;
    private String tea_id;
    private String tea_name;
    private String stu_college;
    private String stu_collegename;
    private float grade;

    public String getStu_college() {
        return stu_college;
    }

    public void setStu_college(String stu_college) {
        this.stu_college = stu_college;
    }

    public String getStu_collegename() {
        return stu_collegename;
    }

    public void setStu_collegename(String stu_collegename) {
        this.stu_collegename = stu_collegename;
    }

    public String getTea_id() {
        return tea_id;
    }

    public void setTea_id(String tea_id) {
        this.tea_id = tea_id;
    }

    public String getTea_name() {
        return tea_name;
    }

    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getCou_name() {
        return cou_name;
    }

    public void setCou_name(String cou_name) {
        this.cou_name = cou_name;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getCou_id() {
        return cou_id;
    }

    public void setCou_id(String cou_id) {
        this.cou_id = cou_id;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}

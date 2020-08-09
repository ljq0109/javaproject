package com.lijiaqing.studentmanage.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Course {
    private String cou_id;
    private String cou_name;
    private String cou_college;
    private String cou_collegename;
    private float cou_credit;
    private String cou_teacher;
    private String cou_teachername;

    public String getCou_collegename() {
        return cou_collegename;
    }

    public void setCou_collegename(String cou_collegename) {
        this.cou_collegename = cou_collegename;
    }

    public String getCou_teachername() {
        return cou_teachername;
    }

    public void setCou_teachername(String cou_teachername) {
        this.cou_teachername = cou_teachername;
    }

    public String getCou_teacher() {
        return cou_teacher;
    }

    public void setCou_teacher(String cou_teacher) {
        this.cou_teacher = cou_teacher;
    }

    public String getCou_id() {
        return cou_id;
    }

    public void setCou_id(String cou_id) {
        this.cou_id = cou_id;
    }

    public String getCou_name() {
        return cou_name;
    }

    public void setCou_name(String cou_name) {
        this.cou_name = cou_name;
    }

    public String getCou_college() {
        return cou_college;
    }

    public void setCou_college(String cou_college) {
        this.cou_college = cou_college;
    }

    public float getCou_credit() {
        return cou_credit;
    }

    public void setCou_credit(float cou_credit) {
        this.cou_credit = cou_credit;
    }
}

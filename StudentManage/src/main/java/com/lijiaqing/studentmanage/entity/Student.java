package com.lijiaqing.studentmanage.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Student {
    public String stu_id;
    public String stu_name;
    public String stu_sex;
    public String stu_birth;
    public String stu_college;
    public String stu_subject;
    public String stu_class;
    public String stu_collegename;
    public String stu_subjectname;
    public String intime;
    public String stu_state;
    public String stu_statename;
    public String sanhao;

    public String getSanhao() {
        return sanhao;
    }

    public void setSanhao(String sanhao) {
        this.sanhao = sanhao;
    }

    public String getStu_collegename() {
        return stu_collegename;
    }

    public void setStu_collegename(String stu_collegename) {
        this.stu_collegename = stu_collegename;
    }

    public String getStu_subjectname() {
        return stu_subjectname;
    }

    public void setStu_subjectname(String stu_subjectname) {
        this.stu_subjectname = stu_subjectname;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime;
    }

    public String getStu_state() {
        return stu_state;
    }

    public void setStu_state(String stu_state) {
        this.stu_state = stu_state;
    }

    public String getStu_statename() {
        return stu_statename;
    }

    public void setStu_statename(String stu_statename) {
        this.stu_statename = stu_statename;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_sex() {
        return stu_sex;
    }

    public void setStu_sex(String stu_sex) {
        this.stu_sex = stu_sex;
    }

    public String getStu_birth() {
        return stu_birth;
    }

    public void setStu_birth(String stu_birth) {
        this.stu_birth = stu_birth;
    }

    public String getStu_college() {
        return stu_college;
    }

    public void setStu_college(String stu_college) {
        this.stu_college = stu_college;
    }

    public String getStu_subject() {
        return stu_subject;
    }

    public void setStu_subject(String stu_subject) {
        this.stu_subject = stu_subject;
    }

    public String getStu_class() {
        return stu_class;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }
}

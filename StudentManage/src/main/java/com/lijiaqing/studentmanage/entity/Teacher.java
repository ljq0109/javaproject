package com.lijiaqing.studentmanage.entity;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Teacher {
    private String tea_id;
    private String tea_name;
    private String tea_sex;
    private String tea_college;
    private String col_name;

    public String getCol_name() {
        return col_name;
    }

    public void setCol_name(String col_name) {
        this.col_name = col_name;
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

    public String getTea_sex() {
        return tea_sex;
    }

    public void setTea_sex(String tea_sex) {
        this.tea_sex = tea_sex;
    }

    public String getTea_college() {
        return tea_college;
    }

    public void setTea_college(String tea_college) {
        this.tea_college = tea_college;
    }
}

package com.lijiaqing.studentmanage.entity;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Subject {
    private String sub_id;
    private String sub_name;
    private String sub_college;//专业所属学院

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public String getSub_college() {
        return sub_college;
    }

    public void setSub_college(String sub_college) {
        this.sub_college = sub_college;
    }
}

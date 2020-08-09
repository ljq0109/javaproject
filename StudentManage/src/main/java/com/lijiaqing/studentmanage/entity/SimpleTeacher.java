package com.lijiaqing.studentmanage.entity;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class SimpleTeacher {
    private String tea_id;
    private String tea_name;

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
}

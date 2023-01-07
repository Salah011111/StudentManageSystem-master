package com.example.demo.domain;

import org.apache.ibatis.annotations.Param;


import java.util.List;

public class Student {
    private int id;
    private String name;
    private int age;


    private String sex;
    private String setupTime;
    private String updateTime;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSetupTime() {
        return setupTime;
    }

    public void setSetupTime(String setupTime) {
        this.setupTime = setupTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }



    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



    @Override
    public String toString() {

        return "[{" +
                "id:" + id +
                ", name:'" + name + '\'' +
                ", sex:'" + sex + '\'' +
                ", setup_time:'" + setupTime + '\'' +
                ", upString_time:'" + updateTime + '\'' +
                "}]";
    }
}

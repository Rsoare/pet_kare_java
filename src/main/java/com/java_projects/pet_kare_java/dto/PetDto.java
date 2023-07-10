package com.java_projects.pet_kare_java.dto;

import com.java_projects.pet_kare_java.model.Group;
import com.java_projects.pet_kare_java.model.Trait;

import java.util.Set;

public class PetDto {
    private String name;

    private int age;

    private float weight;

    private String sex;

    private long group_id;

    private long traits_id;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public long getTraits_id() {
        return traits_id;
    }

    public void setTraits_id(long traits_id) {
        this.traits_id = traits_id;
    }
}

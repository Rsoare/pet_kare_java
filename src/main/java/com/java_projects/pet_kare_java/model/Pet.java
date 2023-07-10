package com.java_projects.pet_kare_java.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(columnDefinition = "DECIMAL",nullable = false)
    private float weight;

    @Column(length = 20,nullable = false)
    private String sex;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Group group;

    @ManyToMany
    @JoinTable(name="pet_model_trait",
        joinColumns = @JoinColumn(name = "pet_fk"),
        inverseJoinColumns = @JoinColumn(name = "trait_fk"))
    private Set<Trait> traits;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createAt;

    @UpdateTimestamp
    @Column(updatable = true)
    private Date updateAt;

    public Pet(){

    }

    public Pet(String name, int age, float weight, String sex, Group group) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.sex = sex;
        this.group = group;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<Trait> getTraits() {
        return traits;
    }

    public void setTraits(Set<Trait> traits) {
        this.traits = traits;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", sex='" + sex + '\'' +
                ", group=" + group +
                ", traits=" + traits +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}


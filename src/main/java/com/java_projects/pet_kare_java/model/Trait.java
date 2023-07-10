package com.java_projects.pet_kare_java.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "trait")
public class Trait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 20,nullable = false)
    private String name;

    @ManyToMany(mappedBy = "traits")
    private Set<Pet> pets;
    @CreationTimestamp
    @Column(updatable = false)
    private Date createAt;

    public Trait(){

    }
    public Trait(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Trait{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pets=" + pets +
                ", createAt=" + createAt +
                '}';
    }
}

package com.java_projects.pet_kare_java.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50,nullable = false)
    private String scientific_name;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;

    public Group(){

    }

    public Group(String scientific_name) {
        this.scientific_name = scientific_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScientific_name() {
        return scientific_name;
    }

    public void setScientific_name(String scientific_name) {
        this.scientific_name = scientific_name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", scientific_name='" + scientific_name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

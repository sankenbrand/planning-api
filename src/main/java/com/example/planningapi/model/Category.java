package com.example.planningapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    private String category_name;
   
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date created_at;

    public int getCategoryId() {
        return category_id;
    }

    public void setCategoryId(int id) {
        this.category_id = id;
    }

    public String getCategoryName() {
        return category_name;
    }

    public void setCategoryName(String name) {
        this.category_name = name;
    } 
}

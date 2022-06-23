package com.example.planningapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "users") 
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date date;
    private String category;
    private String preferred_time;
    private String selected_time;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPreferredTime() {
        return preferred_time;
    }

    public void setPreferredTime(String preferred_time) {
        this.preferred_time = preferred_time;
    }

    public String getSelectedTime() {
        return selected_time;
    }

    public void setSelectedTime(String selected_time) {
        this.selected_time = selected_time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }
}

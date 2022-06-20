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

    @Lob
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
/* public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    private int user_id;
    @Lob
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "planned_event_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Event event;

    private String category;
    private String preferred_time;
    private String selected_time;
    private Date date;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "updated_at", nullable = true)
    private Date updated_at; 

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = id;
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

    public Event getEvent() {
        return event;
      }
    
      public void setEvent(Event event) {
        this.event = event;
      }
} */

package com.example.planningapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "category")
    private String category;
    @Column(name = "time")
    private String time;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "event_id")
    private Set<User> users = new HashSet<>();
    public Event() {
    }
    public Event(Date date, String category, String time) {
      this.date = date;
      this.category = category;
      this.time = time;
    } 

    public long getId() {
        return id;
      }
    
      public Date getDate() {
        return date;
      }
    
      public void setDate(Date date) {
        this.date = date;
      }
    
      public String getCategory() {
        return category;
      }
    
      public void setCategory(String category) {
        this.category = category;
      }
    
      public String getTime() {
        return time;
      }
    
      public void setTime(String time) {
        this.time = time;
      }
      
      public Set<User> getUsers() {
        return users;
      }
    
      public void setUsers(Set<User> users) {
        this.users = users;
      }
      
      public void removeUsers() {
        this.users.clear();
      }
      
      @Override
      public String toString() {
        return "Users [id=" + id + ", date=" + date + ", category=" + category + ", time=" + time + "]";
      }
}


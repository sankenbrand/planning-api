/* package com.example.planningapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table (name = "userEvent")
public class UserEvent {
    @Id
    @Column (name = "user_event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_event_id;
    
    @Column(name = "event_id")
    private int event_id;

    @Column(name = "date")
    private Date date;

    @Column(name = "user_id")
    private int user_id;
    

    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date createdAt;  
} */
package com.example.planningapi.repository;

import com.example.planningapi.model.Event;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    
}

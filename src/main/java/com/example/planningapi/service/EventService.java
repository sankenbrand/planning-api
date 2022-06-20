 package com.example.planningapi.service;

 
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.planningapi.model.Event;
import com.example.planningapi.repository.EventRepository;

@Service
@Transactional
public class EventService {
    @Autowired
    private EventRepository eventRepo;
     
    public List<Event> listAll() {
        return eventRepo.findAll();
    }
     
/*     public void save(Event event) {
        eventRepo.save(event);
    }
     
    public Event get(Integer eventId) {
        return eventRepo.findById(eventId).get();
    }
     
    public void delete(Integer eventId) {
        eventRepo.deleteById(eventId);
    }   */
} 

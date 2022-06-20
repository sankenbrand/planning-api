package com.example.planningapi.controller;

import com.example.planningapi.exception.ResourceNotFoundException;
import com.example.planningapi.model.Event;
import com.example.planningapi.repository.EventRepository;
import com.example.planningapi.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EventController {
    @Autowired
    EventService service;
    @Autowired
    EventRepository eventRepository;

    @GetMapping("/events")
    public List<Event> list() {
        System.out.println("GET events");
        return service.listAll();
    }
    
    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") long id) {
        System.out.println("GET event by id");
      Event event = eventRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Not found event with id = " + id));
        System.out.println(">> get event by id " + id);
      return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        System.out.println("POST event");
      Event _event = eventRepository.save(new Event(event.getDate(), event.getCategory(), event.getTime()));
      System.out.println(">> event successfully created");
      return new ResponseEntity<>(_event, HttpStatus.CREATED);
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable("id") long id, @RequestBody Event eventDetails) {
        System.out.println("PUT event");
      Event event = eventRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Not found event with id = " + id));
      event.setCategory(eventDetails.getCategory());
      event.setTime(eventDetails.getTime());
      System.out.println(">> event successfully updated");
      return new ResponseEntity<>(eventRepository.save(event), HttpStatus.OK);
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable("id") long id) {
        System.out.println("DELETE event by id");
        eventRepository.deleteById(id);
        System.out.println(">> event successfully deleted");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @DeleteMapping("/events")
    public ResponseEntity<HttpStatus> deleteAllEvents() {
        System.out.println("DELETE all events");
        eventRepository.deleteAll();
        System.out.println(">> all events successfully deleted");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

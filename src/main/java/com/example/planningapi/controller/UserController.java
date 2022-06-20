package com.example.planningapi.controller;

import com.example.planningapi.exception.ResourceNotFoundException;
import com.example.planningapi.model.User;
import com.example.planningapi.model.Event;
import com.example.planningapi.repository.EventRepository;
import com.example.planningapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/events/{eventId}/users")
    public ResponseEntity<List<User>> getAllUsersByEventId(@PathVariable(value = "eventId") Long eventId) {    
        System.out.println("GET all users by eventId");
        Event event = eventRepository.findById(eventId)
          .orElseThrow(() -> new ResourceNotFoundException("Not found event with id = " + eventId));
      List<User> users = new ArrayList<User>();
      users.addAll(event.getUsers());
      
      return new ResponseEntity<>(users, HttpStatus.OK);
    }

 /*    @GetMapping("/events/{id}")
    public ResponseEntity<User> getUsersByEventId(@PathVariable(value = "id") Long id) {
      User user = userRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Not found user with id = " + id));
      return new ResponseEntity<>(user, HttpStatus.OK);
    } */

    @PostMapping("/events/{eventId}/users")
    public ResponseEntity<User> createUser(@PathVariable(value = "eventId") Long eventId,
        @RequestBody User userRequest) {
            System.out.println("POST user");
            User user = eventRepository.findById(eventId).map(event -> {
                event.getUsers().add(userRequest);
                return userRepository.save(userRequest);
            }).orElseThrow(() -> new ResourceNotFoundException("Not found event with id = " + eventId));
            System.out.println(">> user successfully created");
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        
        @PutMapping("/users/{id}")
        public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User userRequest) {
            System.out.println("PUT user");
            User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("UserId " + id + "not found"));
            user.setName(userRequest.getName());
            user.setCategory(userRequest.getCategory());
            user.setPreferredTime(userRequest.getPreferredTime());
            user.setSelectedTime(userRequest.getSelectedTime());
            System.out.println(">> user successfully updated");
            return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
        }
        
        @DeleteMapping("/users/{id}")
        public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
            System.out.println("DELETE user by id");
            userRepository.deleteById(id);
            System.out.println(">> user successfully deleted");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        @DeleteMapping("/events/{eventId}/users")
        public ResponseEntity<List<User>> deleteAllUsersOfEvent(@PathVariable(value = "eventId") Long eventId) {
            System.out.println("DELETE all users");
            Event event = eventRepository.findById(eventId)
            .orElseThrow(() -> new ResourceNotFoundException("Not found event with id = " + eventId));
            
            event.removeUsers();
            eventRepository.save(event);
            
            System.out.println(">> all users successfully deleted");
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

  /*   @GetMapping("/events/{plannedEventId}/users")
    public ResponseEntity<List<User>> getAllCommentsByTutorialId(@PathVariable(value = "plannedEventId") Integer plannedEventId) {
      if (!eventRepository.existsById(plannedEventId)) {
        throw new ResourceNotFoundException("Event", "eventId", plannedEventId);
      }
      List<User> users = userRepository.findByPlannedEventId(plannedEventId);
      return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/events/{plannedEventId}/users")
    public ResponseEntity<User> createUser(@PathVariable(value = "plannedEventId") Integer plannedEventId,
        @RequestBody User userRequest) {
      User User = eventRepository.findById(plannedEventId).map(event -> {
        userRequest.setEvent(event);
        return userRepository.save(userRequest);
      }).orElseThrow(() -> new ResourceNotFoundException("Event", "eventId", plannedEventId));
      return new ResponseEntity<>(User, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public List<User> list() {
        System.out.println("GET users");
        return service.listAll();
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        System.out.println("GET user");
        try {
            User user = service.get(id);
            System.out.println(">> get user with id " + id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @PostMapping("/users")
    public ResponseEntity<String> add(@RequestBody User user) {
        System.out.println("POST user");
        service.save(user);
        System.out.println(">> user successfully created");
        return new ResponseEntity<String>("User successfully created!", HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        System.out.println("DELETE user");
        service.delete(id);
        System.out.println(">> user successfully deleted");
        return ResponseEntity.ok("User successfully deleted!");
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable(value = "id") Integer id, @RequestBody User userDetails) {
        System.out.println("PUT user");
        
        User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        
        user.setSelectedTime(userDetails.getSelectedTime());
        
        User updatedUser = userRepository.save(user);
        System.out.println(">> user successfully updated");
        return updatedUser;
    } 
     */
}

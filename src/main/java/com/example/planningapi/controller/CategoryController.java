package com.example.planningapi.controller;

import com.example.planningapi.model.Category;
import com.example.planningapi.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    public List<Category> list() {
        System.out.println("GET categories");
        return service.listAll();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> get(@PathVariable Integer id) {
        try {
            Category category = service.get(id);
            System.out.println("get category with id " + id);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }      
    }

    @PostMapping("/categories")
    public void add(@RequestBody Category category) {
        System.out.println("category successfully created");
        service.save(category);
    }
    
    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable Integer id) {
        System.out.println("category successfully deleted");
        service.delete(id);
    }
}

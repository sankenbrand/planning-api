package com.example.planningapi.service;

import java.util.List;
 
import javax.transaction.Transactional;

import com.example.planningapi.model.Category;
import com.example.planningapi.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;
     
    public List<Category> listAll() {
        return categoryRepo.findAll();
    }
     
    public void save(Category category) {
        categoryRepo.save(category);
    }
     
    public Category get(Integer id) {
        return categoryRepo.findById(id).get();
    }
     
    public void delete(Integer id) {
        categoryRepo.deleteById(id);
    } 
}

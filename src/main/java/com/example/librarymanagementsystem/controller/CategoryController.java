package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Category;
import com.example.librarymanagementsystem.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        List<Category> categoriesList = categoryService.getAllCategories();
        return new ResponseEntity<>(categoriesList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        Category category1 = categoryService.createCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editCategory(@PathVariable long id,
                                           @RequestBody Category category) {
        Category category1 = categoryService.updateCategory(id, category);
        return new ResponseEntity<>(category1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.NO_CONTENT);
    }
}

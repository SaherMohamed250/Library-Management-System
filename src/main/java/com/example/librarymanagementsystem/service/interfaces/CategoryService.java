package com.example.librarymanagementsystem.service.interfaces;

import com.example.librarymanagementsystem.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    String deleteCategory(Long id);
}

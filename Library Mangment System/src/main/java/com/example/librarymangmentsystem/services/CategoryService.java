package com.example.librarymangmentsystem.services;

import com.example.librarymangmentsystem.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    String deleteCategory(Long id);
}

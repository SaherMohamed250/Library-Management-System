package com.example.librarymangmentsystem.services;

import com.example.librarymangmentsystem.models.Category;
import com.example.librarymangmentsystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category) {
        Category category1=new Category();
        category1.setName(category.getName());
        category1.setParent(category.getParent());
        return categoryRepository.save(category1);
    }

    public Category updateCategory(Long id, Category category) {
        Category category1 =categoryRepository.findById(id).get();
        category1.setName(category.getName());
        category1.setParent(category.getParent());
        return categoryRepository.save(category1);
    }

    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "DELETED";
    }

}

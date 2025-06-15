package com.example.librarymanagementsystem.service.Implementation;

import com.example.librarymanagementsystem.model.Category;
import com.example.librarymanagementsystem.repository.CategoryRepository;
import com.example.librarymanagementsystem.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category createCategory(Category category) {
        Category category1=new Category();
        category1.setCategoryName(category.getCategoryName());
        category1.setParent(category.getParent());
        return categoryRepository.save(category1);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category category1 =categoryRepository.findById(id).get();
        category1.setCategoryName(category.getCategoryName());
        category1.setParent(category.getParent());
        return categoryRepository.save(category1);
    }

    @Override
    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "deleteCategory";
    }
}

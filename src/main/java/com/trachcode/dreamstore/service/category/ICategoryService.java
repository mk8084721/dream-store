package com.trachcode.dreamstore.service.category;

import com.trachcode.dreamstore.model.Category;

import java.util.List;

public interface ICategoryService {
    Category addCategory(Category category);
    Category updateCategory(Category category, Long id);
    void deleteCategory(Long categoryId);
    List<Category> getAllCategories();
    Category getCategoryById(Long categoryId);
    Category getCategoryByName(String Name);
}

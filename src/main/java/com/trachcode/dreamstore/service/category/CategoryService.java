package com.trachcode.dreamstore.service.category;

import com.trachcode.dreamstore.exeption.CategoryNotFoundException;
import com.trachcode.dreamstore.model.Category;
import com.trachcode.dreamstore.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return null;
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return Optional.ofNullable(getCategoryById(id))
                .map(oldCategory->{
                    oldCategory.setName(category.getName());
                    return categoryRepository.save(oldCategory);
                })
                .orElseThrow(()-> new CategoryNotFoundException("Category not found!"));
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.findById(categoryId)
                .ifPresentOrElse(categoryRepository::delete,
                        () -> {
                    throw new CategoryNotFoundException("Category not found!");
                });
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(()-> new CategoryNotFoundException("Category not found!"));
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }
}

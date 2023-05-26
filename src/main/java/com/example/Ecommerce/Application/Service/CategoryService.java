package com.example.Ecommerce.Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.Application.Models.Category;
import com.example.Ecommerce.Application.Repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(Category category) throws Exception{
         categoryRepository.save(category);
    }

    public void deleteCategory(int id) throws Exception{
        categoryRepository.deleteById(id);
    }

    public void updateCategory(int id) throws Exception{
         Category cat=categoryRepository.findById(id).get();
         categoryRepository.save(cat);
    }

    public Category getCategory(int id) throws Exception{
          return categoryRepository.findById(id).get();
    }

    public List<Category> getAllcategories() throws Exception{
        return categoryRepository.findAll();
    }
}

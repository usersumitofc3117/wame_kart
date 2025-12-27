package com.example.wamekart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.wamekart.model.Category;

@Service
public interface CategoryService  {
    public Category saveCategory(Category category);

public boolean existCAtegory(String categoryname);
public List<Category> listAllCAtegory();
public boolean deleteCategory(Long id);
public Category getCAtegoryById(Long id);
}

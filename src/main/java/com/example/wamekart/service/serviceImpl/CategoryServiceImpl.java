package com.example.wamekart.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.wamekart.model.Category;
import com.example.wamekart.repository.CategoryRepo;
import com.example.wamekart.service.CategoryService;




@Service
public class CategoryServiceImpl implements CategoryService {
@Autowired
private CategoryRepo catrepo;
    @Override
    public Category saveCategory(Category category) {

      return catrepo.save(category);
    }



    @Override
    public boolean existCAtegory(String categoryname) {
     return catrepo.existsBycategoryname(categoryname);
    }

    @Override
    public List<Category> listAllCAtegory() {
       return catrepo.findAll();
    }

    @Override
    public boolean deleteCategory(Long id) {
Category category = catrepo.findById(id).orElse(null);
if (!ObjectUtils.isEmpty(category)) {
  catrepo.delete(category);
return true;
}
return false;
       
    }
@Override
public Category getCAtegoryById(Long id) {
 Category category = catrepo.findById(id).orElse(null);

  return category;
}
    
}

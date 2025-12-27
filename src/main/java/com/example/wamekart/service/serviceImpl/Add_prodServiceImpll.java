package com.example.wamekart.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.wamekart.model.Addproduct;
import com.example.wamekart.repository.Add_prodrepo;
import com.example.wamekart.service.Add_prodService;
@Service
public class Add_prodServiceImpll implements Add_prodService{
@Autowired
private Add_prodrepo add_repo;
    @Override
    public Addproduct saveproductDetail(Addproduct addprod, MultipartFile image) throws Exception {
addprod.setCategoryname(addprod.getCategoryname());
addprod.setImageName(image.getOriginalFilename());
addprod.setImageType(image.getContentType());
addprod.setImageData(image.getBytes());

     return add_repo.save(addprod);
    }
     
    @Override
    public List<Addproduct> getAllproduct() {
       
        return add_repo.findAll();
    }
}

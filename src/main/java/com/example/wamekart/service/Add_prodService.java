package com.example.wamekart.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.wamekart.model.Addproduct;
@Service
public interface Add_prodService {
    public Addproduct saveproductDetail(Addproduct addprod ,MultipartFile image) throws Exception;
public List<Addproduct> getAllproduct();
}

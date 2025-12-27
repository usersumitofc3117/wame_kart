package com.example.wamekart.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.wamekart.model.Addproduct;
import com.example.wamekart.model.Category;
import com.example.wamekart.service.Add_prodService;
import com.example.wamekart.service.CategoryService;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/admin")
public class Admincontroller {

    private final Add_prodService addservice;

    public Admincontroller(Add_prodService addservice) {
        this.addservice = addservice;
    }
@Autowired
private CategoryService catservice;

@GetMapping("/")
public String getadmin(){
return"admin/index";
}

@GetMapping("view_prod")
public String viewprod(Model model){

model.addAttribute("products",addservice.getAllproduct());
return"admin/view_prod";
}
@GetMapping("check_order")
public String checkorder(){
return"admin/check_orders";
}
@GetMapping("check_user")
public String checkuser(){
return"admin/check_users";
}
@GetMapping("add_admin")
public String addAdmin(){
return"admin/addAdmin";
}
// @Autowired
// private Add_prodService addservice;
    @GetMapping("/add_prod")
public String addproduct(Model model){
List<Category> categories =catservice.listAllCAtegory();
model.addAttribute("categories",categories);
model.addAttribute("Addproduct",new Addproduct());
return"admin/add_product";
}
@PostMapping("/add_prodnew")
public String addproduct(@ModelAttribute("Addproduct")Addproduct product,@RequestParam("image")MultipartFile image,Model model) throws IOException, Exception{
addservice.saveproductDetail(product, image);
model.addAttribute("message", "product added successfully");
        return "redirect:/admin/add_prod";
}
           
  @GetMapping("/add_cate")
public String addcategory(Model model){
model.addAttribute("category",new Category());
model.addAttribute("categories",catservice.listAllCAtegory());
return"admin/category";
}  
@PostMapping("/catsave")
public String saveCategory(@ModelAttribute Category category,@RequestParam("file")MultipartFile file,Model model) throws IOException{

 String imageName =file!=null ? file.getOriginalFilename():"default.png";
category.setImageName(imageName);
if (catservice.existCAtegory(category.getCategoryname())) {
    model.addAttribute("errormsg","category already exists");
}else{
 Category savecategory = catservice.saveCategory(category);
if (ObjectUtils.isEmpty(savecategory)) {
    model.addAttribute("errormsg", "internal server error");
}else{
  Path uploadPath = Paths.get("uploads/category_img");
            if (Files.notExists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }                                       
            // copy the file
            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
  model.addAttribute("successmsg", " category saved successfully ");
}
}
return "redirect:/admin/add_cate";
}

@GetMapping("/deleteCategory/{id}")
public String deleteCategory(@PathVariable Long id,HttpSession httpSession,Category category){
Boolean deleteCategory = catservice.deleteCategory(id);
if (deleteCategory) {
    httpSession.setAttribute("successmsg","category successfully delted");
}else{
httpSession.setAttribute("errormsg", "something wrong on server");
}
return "redirect:/admin/add_cate";
}
@GetMapping("/editthis/{id}")
public String editCAtegory( @PathVariable Long id,Model model){
model.addAttribute("category",catservice.getCAtegoryById(id));
return "admin/editcategory";
}


@PostMapping("/updateCategory")
public String updateCategory(
        @ModelAttribute Category category,
        @RequestParam("file") MultipartFile file,
        HttpSession httpSession) throws IOException {

    Category oldCategory = catservice.getCAtegoryById(category.getId());
    if (oldCategory == null) {
        httpSession.setAttribute("errormsg", "Category not found");
        return "redirect:/admin/add_cate";
    }

    // Update fields
    oldCategory.setCategoryname(category.getCategoryname());
    oldCategory.setIsactive(category.getIsactive());

    // Handle file upload if a new file was provided
    if (!file.isEmpty()) {
        String imageName = file.getOriginalFilename();
        oldCategory.setImageName(imageName);

        // Save the uploaded file
        Path uploadPath = Paths.get("uploads/category_img");
        if (Files.notExists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        Path filePath = uploadPath.resolve(imageName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    }

    // Save updated category
    Category updatedCategory = catservice.saveCategory(oldCategory);

    if (updatedCategory != null) {
        httpSession.setAttribute("successmsg", "Category updated successfully");
    } else {
        httpSession.setAttribute("errormsg", "Something went wrong");
    }

    // Redirect back to edit form
    return "redirect:/admin/editthis/" + category.getId();
}


 







}



























































































































package com.example.wamekart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
@GetMapping("/log_page")
    public String loginPage(){
return "login";
}
@GetMapping("/home")
    public String homePage(){
return "index";
}
@GetMapping("/reg_page")
    public String regPage(){
return "register";
}
@GetMapping("/view_details")
    public String onPage(){
return "detailsProduct";
}
@GetMapping("/admine")
    public String adminPage(){
return "admin/admin";
}
@GetMapping("/add_prod")
public String addproduct(){
return"admin/add_prod";
}
@GetMapping("/add_cate")
public String addcategory(){
return"admin/add_category";
}
@GetMapping("view_prod")
public String viewprod(){
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
}

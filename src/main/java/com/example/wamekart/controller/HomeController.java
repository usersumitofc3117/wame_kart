package com.example.wamekart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.wamekart.model.Customer;
import com.example.wamekart.service.CustomerService;

@Controller
@RequestMapping("/")
public class HomeController {
@Autowired
private CustomerService cusserv;
@GetMapping("/")
    public String myhomePage(){
return "index";
}
@GetMapping("/customer_product")
    public String customerproductPage(){
return "productscustomer";
}
@GetMapping("/customer_productdetails")
    public String customerproductDetailPage(){
return "detailsProduct";
}

@GetMapping("/signin")
    public String loginPage(){
return "login";
}
@GetMapping("/home")
    public String homePage(){
return "index";
}
@GetMapping("/reg_page")
    public String regPage(Model model){
model.addAttribute("customer", new Customer());
return "register";
}
@PostMapping("/saveCustomer")
public String getCustomer(@ModelAttribute Customer customer){

cusserv.getRegister(customer);
return "redirect:/reg_page";
}
@GetMapping("/view_details")
    public String onPage(){
return "detailsProduct";
}

}

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
}

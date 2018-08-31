package com.skp.analog.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    
     @RequestMapping("/admin")
     public String admin() {
          return "admin";
     }
    
     @RequestMapping("/user")
     public String user() {
          return "user";
     }
     
     @RequestMapping("/loginMain")
     public String loginMain() {
          return "apiLogin";
     }
}
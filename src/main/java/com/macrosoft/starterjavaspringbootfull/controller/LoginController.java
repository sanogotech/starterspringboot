package com.macrosoft.starterjavaspringbootfull.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

 
    @GetMapping("/loginecole")
    public String login() {
        return "loginecole";
    }


}

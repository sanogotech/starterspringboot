package com.macrosoft.starterjavaspringbootfull.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
	
	


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Invalidating the session to log out the user
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Clear the authentication context
        SecurityContextHolder.clearContext();

        // Redirect the user to the home page or any other page after logout
        return "redirect:/";
    }
    
    
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied"; // Cette chaîne correspond au nom de votre fichier access-denied.html dans les templates Thymeleaf.
    }
}


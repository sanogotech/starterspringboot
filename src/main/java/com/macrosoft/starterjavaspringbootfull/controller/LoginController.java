package com.macrosoft.starterjavaspringbootfull.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/loginecole")
    public String login() {
        return "loginecole";
    }
    
    @PostMapping("/loginecole")
    public String performLogin(@RequestParam String username, @RequestParam String password) {
        // Logique d'authentification ici (par exemple, utiliser Spring Security)
        // Rediriger vers la page d'accueil si l'authentification réussit, sinon vers la page de connexion avec un message d'erreur
        // return "redirect:/home"; // Redirige vers la page d'accueil après l'authentification réussie
        // return "redirect:/loginecole?error=true"; // Redirige vers la page de connexion avec un message d'erreur
        return "redirect:/loginecole?logout=true"; // Redirige vers la page de connexion avec un message de déconnexion
    }
}

package com.macrosoft.starterjavaspringbootfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/loginecole")
    public String login() {
        return "loginecole";
    }

    @PostMapping("/loginecole")
    public String performLogin(@RequestParam String username, @RequestParam String password) {
        try {
            Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Votre logique d'authentification ici (par exemple, vérifier le rôle de l'utilisateur)
            // Rediriger vers la page d'accueil si l'authentification réussit
            return "redirect:/indexecole";
        } catch (Exception e) {
            // Gérer les erreurs d'authentification (par exemple, mot de passe incorrect)
            // Rediriger vers la page de connexion avec un message d'erreur
            return "redirect:/loginecole?error=true";
        }
    }
}

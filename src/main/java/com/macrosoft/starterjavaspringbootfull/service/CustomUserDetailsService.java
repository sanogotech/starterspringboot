package com.macrosoft.starterjavaspringbootfull.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.macrosoft.starterjavaspringbootfull.configuration.CustomUserDetails;
import com.macrosoft.starterjavaspringbootfull.model.User;
import com.macrosoft.starterjavaspringbootfull.repository.UserRepository;

/**
 * Dans ce code :

CustomUserDetails implémente l'interface UserDetails de Spring Security.
Les détails de l'utilisateur, tels que le nom d'utilisateur, le mot de passe, le statut d'activation et les rôles, sont récupérés à partir de l'objet User.
Les rôles de l'utilisateur sont convertis en objets GrantedAuthority.
Les méthodes de l'interface UserDetails sont implémentées pour fournir les informations nécessaires à Spring Security pour l'authentification et l'autorisation.
 * @author SOULEYSANOGO
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Utilisateur introuvable: " + username);
        }
        return new CustomUserDetails(user);
    }
}

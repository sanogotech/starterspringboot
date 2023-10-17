package com.macrosoft.starterjavaspringbootfull.configuration;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.macrosoft.starterjavaspringbootfull.model.User;

// Cette classe représente les détails de l'utilisateur personnalisés pour Spring Security.
public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    // Constructeur prenant les informations de l'utilisateur.
    public CustomUserDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.active = user.isActive();
        // Convertit les rôles de l'utilisateur en objets GrantedAuthority.
        this.authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());
    }

    // Retourne les autorités (rôles) associées à l'utilisateur.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // Retourne le mot de passe de l'utilisateur.
    @Override
    public String getPassword() {
        return password;
    }

    // Retourne le nom d'utilisateur de l'utilisateur.
    @Override
    public String getUsername() {
        return username;
    }

    // Indique si le compte de l'utilisateur est actif ou non.
    @Override
    public boolean isAccountNonExpired() {
        return true; // Ici, vous pouvez ajouter la logique pour vérifier si le compte a expiré.
    }

    // Indique si le compte de l'utilisateur est verrouillé ou non.
    @Override
    public boolean isAccountNonLocked() {
        return true; // Ici, vous pouvez ajouter la logique pour vérifier si le compte est verrouillé.
    }

    // Indique si les informations d'identification de l'utilisateur ont expiré ou non.
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Ici, vous pouvez ajouter la logique pour vérifier si les informations d'identification ont expiré.
    }

    // Indique si le compte de l'utilisateur est activé ou non.
    @Override
    public boolean isEnabled() {
        return active;
    }
}

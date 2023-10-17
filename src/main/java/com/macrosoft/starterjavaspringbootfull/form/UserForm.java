package com.macrosoft.starterjavaspringbootfull.form;

import javax.validation.constraints.NotEmpty;

public class UserForm {

    @NotEmpty(message = "Le nom d'utilisateur ne peut pas être vide")
    private String username;

    @NotEmpty(message = "Le mot de passe ne peut pas être vide")
    private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    // Getters and setters
    
    
}

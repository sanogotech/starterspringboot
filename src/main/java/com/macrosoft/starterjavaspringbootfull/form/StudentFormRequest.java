package com.macrosoft.starterjavaspringbootfull.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class StudentFormRequest {
    
    @NotEmpty(message = "Le nom de l'étudiant ne peut pas être vide")
    @Size(max = 255, message = "Le nom de l'étudiant ne peut pas dépasser 255 caractères")
    private String name;

    @NotEmpty(message = "Le niveau de l'étudiant ne peut pas être vide")
    @Size(max = 50, message = "Le niveau de l'étudiant ne peut pas dépasser 50 caractères")
    private String grade;

    // Getters et Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

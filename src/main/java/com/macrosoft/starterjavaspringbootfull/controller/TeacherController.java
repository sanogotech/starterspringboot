package com.macrosoft.starterjavaspringbootfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.macrosoft.starterjavaspringbootfull.repository.TeacherRepository;

@Controller
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public String listTeachers(Model model) {
        model.addAttribute("teachers", teacherRepository.findAll());
        return "teachers";
    }

    // Ajoutez d'autres méthodes du contrôleur selon vos besoins (par exemple, ajouter, éditer, supprimer).
}

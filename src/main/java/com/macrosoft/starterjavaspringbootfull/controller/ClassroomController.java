package com.macrosoft.starterjavaspringbootfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.macrosoft.starterjavaspringbootfull.repository.ClassroomRepository;

@Controller
public class ClassroomController {

    @Autowired
    private ClassroomRepository classroomRepository;

    @GetMapping("/classrooms")
    public String listClassrooms(Model model) {
        model.addAttribute("classrooms", classroomRepository.findAll());
        return "classrooms";
    }

    // Ajoutez d'autres méthodes du contrôleur selon vos besoins (par exemple, ajouter, éditer, supprimer).
}

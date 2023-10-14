package com.macrosoft.starterjavaspringbootfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.macrosoft.starterjavaspringbootfull.repository.CourseRepository;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "courses";
    }

    // Ajoutez d'autres méthodes du contrôleur selon vos besoins (par exemple, ajouter, éditer, supprimer).
}


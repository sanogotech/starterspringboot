package com.macrosoft.starterjavaspringbootfull.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.macrosoft.starterjavaspringbootfull.form.StudentFormRequest;
import com.macrosoft.starterjavaspringbootfull.model.Student;
import com.macrosoft.starterjavaspringbootfull.repository.StudentRepository;

/**
 * Contrôleur Spring gérant les requêtes liées aux étudiants de l'école.
 */
@Controller
public class SchoolController {

    @Autowired
    private StudentRepository studentRepository;

 
    @GetMapping("/")
    public String home(Model model,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "10") int size,
                       @RequestParam(defaultValue = "name") String sort,
                       @RequestParam(defaultValue = "") String keyword) {

        Page<Student> studentsPage = studentRepository.findByNameContainingIgnoreCase(keyword, PageRequest.of(page, size, Sort.by(sort)));
        model.addAttribute("students", studentsPage);
        StudentFormRequest studentForm = new StudentFormRequest();
        model.addAttribute("studentForm", studentForm);
        return "index";
    }
    
   


    
  
}

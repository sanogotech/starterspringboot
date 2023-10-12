package com.macrosoft.starterjavaspringbootfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.macrosoft.starterjavaspringbootfull.model.Student;
import com.macrosoft.starterjavaspringbootfull.repository.StudentRepository;

/**
 * Contrôleur Spring gérant les requêtes liées aux étudiants de l'école.
 */
@Controller
public class SchoolController {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Gère la requête GET pour la page d'accueil de l'école.
     * Affiche la liste des étudiants dans le modèle et renvoie le template "index".
     * @param model Objet de modèle Spring pour transporter les données à la vue.
     * @return Le nom du template Thymeleaf à afficher (dans ce cas, "index").
     */
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    /**
     * Gère la requête POST pour ajouter un nouvel étudiant à la base de données.
     * Ajoute l'étudiant à la base de données, indique qu'un message de succès doit être affiché,
     * puis redirige l'utilisateur vers la page d'accueil.
     * @param name Nom de l'étudiant à ajouter.
     * @param grade Niveau de l'étudiant à ajouter.
     * @param model Objet de modèle Spring pour transporter les données à la vue.
     * @return Redirige l'utilisateur vers la page d'accueil ("/").
     */
    @PostMapping("/add-student")
    public String addStudent(String name, String grade, Model model) {
        Student student = new Student();
        student.setName(name);
        student.setGrade(grade);
        
        // Ajouter l'étudiant à la base de données
        studentRepository.save(student);
        
      
        // Indiquer que le message de succès doit être affiché
        model.addAttribute("successMessage", true);
        
        return "redirect:/";
    }
    
  
}

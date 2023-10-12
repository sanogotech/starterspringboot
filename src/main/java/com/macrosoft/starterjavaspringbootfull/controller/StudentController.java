package com.macrosoft.starterjavaspringbootfull.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.macrosoft.starterjavaspringbootfull.model.Student;
import com.macrosoft.starterjavaspringbootfull.repository.StudentRepository;

/**
 * Contrôleur Spring gérant les requêtes liées aux étudiants de l'école.
 */
@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }
    
    

    @GetMapping("/edit-student/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        studentOptional.ifPresent(student -> model.addAttribute("student", student));
        return "edit-student"; // Nom de votre fichier HTML d'édition
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "redirect:/";
    }
    
    
    @GetMapping("/displayaddformstudents")
    public String displayaddformStudents(Model model) {
        return "addform-student";
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
    
    @PostMapping("/update-student/{id}")
    public String updateStudent(@PathVariable Long id, @RequestParam String name, @RequestParam String grade) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(name);
            student.setGrade(grade);
            studentRepository.save(student);
        }
        return "redirect:/";
    }
}

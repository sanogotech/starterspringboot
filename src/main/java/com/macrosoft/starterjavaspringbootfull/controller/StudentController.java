package com.macrosoft.starterjavaspringbootfull.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.macrosoft.starterjavaspringbootfull.form.StudentFormRequest;
import com.macrosoft.starterjavaspringbootfull.model.Student;
import com.macrosoft.starterjavaspringbootfull.repository.StudentRepository;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }
    
    
    @GetMapping("/search")
    public String search(@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword, Model model) {
        List<Student> students = studentRepository.findByNameContainingIgnoreCase(keyword);
        model.addAttribute("students", students);
        return "students"; // Ou le nom de votre template Thymeleaf pour afficher les résultats de la recherche
    }

    @GetMapping("/edit-student/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
   
        
        Optional<Student> studentOptional = studentRepository.findById(id);
        studentOptional.ifPresent(student -> {
            StudentFormRequest studentForm = new StudentFormRequest();
            studentForm.setName(student.getName());
            studentForm.setGrade(student.getGrade());
            model.addAttribute("student", student);
            model.addAttribute("studentForm", studentForm);
        });
        return "edit-student";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/displayaddformstudents")
    public String displayaddformStudents(Model model) {
    	 StudentFormRequest studentForm = new StudentFormRequest();
         model.addAttribute("studentForm", studentForm);// Ajoutez un nouvel objet Student au modèle
        return "addform-student";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute("studentForm") @Valid StudentFormRequest studentForm,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addform-student";
        }

        Student student = new Student();
        student.setName(studentForm.getName());
        student.setGrade(studentForm.getGrade());

        studentRepository.save(student);

        model.addAttribute("successMessage", true);

        return "redirect:/";
    }

    
    @PostMapping("/update-student/{id}")
    public String updateStudent(@PathVariable Long id, @Valid @ModelAttribute("studentForm") StudentFormRequest studentForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Gérer les erreurs de validation
            return "edit-student";
        }

        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(studentForm.getName());
            student.setGrade(studentForm.getGrade());
            studentRepository.save(student);
        }

        return "redirect:/";
    }
}

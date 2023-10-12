package com.macrosoft.starterjavaspringbootfull.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @GetMapping("/edit-student/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        studentOptional.ifPresent(student -> model.addAttribute("student", student));
        return "edit-student";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/displayaddformstudents")
    public String displayaddformStudents(Model model) {
        model.addAttribute("student", new Student()); // Ajoutez un nouvel objet Student au modèle
        return "addform-student";
    }

    @PostMapping("/add-student")
    public String addStudent(@RequestBody @Valid  String name, @RequestBody @Valid  String grade,  Model model,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addform-student";
        }

        Student student = new Student();
        student.setName(name);
        student.setGrade(grade);

        studentRepository.save(student);

        model.addAttribute("successMessage", true);

        return "redirect:/";
    }

    @PostMapping("/update-student/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody @Valid String name, @RequestBody @Valid  String grade, Model model,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-student";
        }

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

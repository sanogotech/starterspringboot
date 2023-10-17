package com.macrosoft.starterjavaspringbootfull.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.macrosoft.starterjavaspringbootfull.form.UserForm;
import com.macrosoft.starterjavaspringbootfull.model.User;
import com.macrosoft.starterjavaspringbootfull.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        User user = new User();
        user.setUsername(userForm.getUsername());
        // Encodez le mot de passe avant de le stocker dans la base de données (vous pouvez utiliser BCryptPasswordEncoder)
        user.setPassword(userForm.getPassword());
        user.setActive(true);
        userRepository.save(user);

        return "redirect:/login?success";
    }
}

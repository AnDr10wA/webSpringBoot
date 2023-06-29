package com.kata.webSpring.controller;

import com.kata.webSpring.model.User;
import com.kata.webSpring.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public String findAll(Model model){
        List<User> users = userServiceImpl.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }
    @GetMapping("/create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/create")
    public String createUser(User user){
        userServiceImpl.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id")  Long id){
        userServiceImpl.deleteById(id);
        return "redirect:/users";
    }
    @GetMapping("update/{id}")
    public String updateUserForm(@PathVariable("id")  Long id, Model model){
        User user = userServiceImpl.findById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }
    @PostMapping("/update")
    public String updateUser(User user){
        userServiceImpl.saveUser(user);
        return "redirect:/users";
    }

}

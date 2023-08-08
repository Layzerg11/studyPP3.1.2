package com.studyPP312.ProjectBoot.controller;

import com.studyPP312.ProjectBoot.entity.User;
import com.studyPP312.ProjectBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userList(Model model, @ModelAttribute("user") User user) {
        model.addAttribute("users", userService.getUserList());
        return "users";
    }

    @GetMapping("/{id}")
    public String user(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping
    public String delete(User user) {
        userService.delete(user);
        return "redirect:/";
    }
}

package com.shubina.springboot.pp312.springboot.Controller;

import com.shubina.springboot.pp312.springboot.Model.User;
import com.shubina.springboot.pp312.springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping(value = "/all")
    public String showAllUsers(Model model) {

        model.addAttribute("allUsers", userService.getAllUsers());

        return "all-Users";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {

        model.addAttribute("user",new User());

        return "add-User";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);

        return "redirect:/users/all";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {

        model.addAttribute("user", userService.getUser(id));

        return "edit-User";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") int id) {

        userService.updateUser(id,user);

        return "redirect:/users/all";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user,
                         @PathVariable("id") int id) {

        userService.deleteUser(id);

        return "redirect:/users/all";
    }
}

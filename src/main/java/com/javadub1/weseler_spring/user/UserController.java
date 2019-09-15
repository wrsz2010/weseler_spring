package com.javadub1.weseler_spring.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

        @GetMapping("/users/{id}")
    public ModelAndView userById(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("user-view");
        modelAndView.addObject("user", userService.findById(id));
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView usersAll(){
        ModelAndView modelAndView = new ModelAndView("users-all");
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}

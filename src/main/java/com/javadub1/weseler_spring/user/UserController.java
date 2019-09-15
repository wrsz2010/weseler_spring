package com.javadub1.weseler_spring.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", "hello hellou");
        return modelAndView;
    }

    @GetMapping("/users/{id}")
    public ModelAndView userById(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("user-view");
        modelAndView.addObject("user", userService.findById(id));
        return modelAndView;
    }

    @GetMapping("/users/all")
    public ModelAndView usersAll(){
        ModelAndView modelAndView = new ModelAndView("users-all");
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }
}

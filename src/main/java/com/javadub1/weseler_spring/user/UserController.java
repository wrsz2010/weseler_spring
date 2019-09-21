package com.javadub1.weseler_spring.user;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ModelAndView userById(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("user-view");
        modelAndView.addObject("user", userService.findById(id));
        return modelAndView;
    }

    @GetMapping
    public ModelAndView usersAll(@RequestParam(name="g", required = false, defaultValue = "") String gender){
        ModelAndView modelAndView = new ModelAndView("users-all");
        modelAndView.addObject("users", StringUtils.isEmpty(gender) ? userService.findAll() : userService.findByGender(gender.toUpperCase()));
        return modelAndView;
    }

    @PostMapping
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}

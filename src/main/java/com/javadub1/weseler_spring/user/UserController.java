package com.javadub1.weseler_spring.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", "hello hellou");
        return modelAndView;
    }
}

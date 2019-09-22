package com.javadub1.weseler_spring.todo;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/todos")
public class TodoControler {

    private TodoService todoService;

    public TodoControler(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ModelAndView todosAll(@RequestParam(name="st", required = false, defaultValue = "") String status){
        ModelAndView modelAndView = new ModelAndView("todos-all");
        modelAndView.addObject("todos", StringUtils.isEmpty(status) ? todoService.findAll() : todoService.findByStatus(status));
        return modelAndView;
    }
    @GetMapping("/{id}")
    public ModelAndView todoById(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("todo-view");
        modelAndView.addObject("todo", todoService.findById(id));
        return modelAndView;
    }
    @PostMapping
    public String saveUser(@ModelAttribute Todo todo) {
        todoService.saveTodo(todo);
        return "redirect:/todos";
    }
}

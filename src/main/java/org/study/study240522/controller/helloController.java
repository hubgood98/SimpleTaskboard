package org.study.study240522.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class helloController {

    @GetMapping("hello")
    public String hello(Model model)
    {
        model.addAttribute("msg", "Hello World");

        return "hello";
    }

    @GetMapping("hello-MVC")
    public String helloMVC(@RequestParam("name")String name, Model model)
    {
        model.addAttribute("name", name);
        return "hello";
    }

}

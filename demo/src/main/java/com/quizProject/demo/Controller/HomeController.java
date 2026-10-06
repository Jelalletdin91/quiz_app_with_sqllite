package com.quizProject.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/users")
    public String users(){
        return "redirect:/index.html";
    }

    @GetMapping("/questions")
    public String questions() {
        return "redirect:/questions.html";
    }

    @GetMapping("/sessions")
    public String sessions() {
        return "redirect:/sessions.html";
    }

}

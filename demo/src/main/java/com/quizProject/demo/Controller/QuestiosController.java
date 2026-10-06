package com.quizProject.demo.Controller;

import com.quizProject.demo.Entity.Questions;
import com.quizProject.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestiosController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/questionjson")
    public List<Questions> questions() {
        return questionService.getAllQuestions();
    }
}

package com.quizProject.demo.service;

import com.quizProject.demo.Entity.Questions;
import com.quizProject.demo.Rpository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionsRepository questionsRepository;

    public List<Questions> getAllQuestions(){
        return questionsRepository.findAll();
    }
}

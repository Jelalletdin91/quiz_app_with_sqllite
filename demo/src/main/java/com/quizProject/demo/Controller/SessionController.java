package com.quizProject.demo.Controller;

import com.quizProject.demo.Entity.Sessions;
import com.quizProject.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/sessionsjson")
    public List<Sessions> sessions(){
        return sessionService.getAllSessions();

    }

}

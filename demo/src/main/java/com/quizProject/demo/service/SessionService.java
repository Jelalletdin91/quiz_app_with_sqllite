package com.quizProject.demo.service;

import com.quizProject.demo.Entity.Sessions;
import com.quizProject.demo.Rpository.SessionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionsRepository sessionsRepository;

    public List<Sessions> getAllSessions(){
        return sessionsRepository.findAll();
    }
}

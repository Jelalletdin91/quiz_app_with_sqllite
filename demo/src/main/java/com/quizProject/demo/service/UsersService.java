package com.quizProject.demo.service;

import com.quizProject.demo.Entity.Users;
import com.quizProject.demo.Rpository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

public List<Users> getAllUsers(){
    return usersRepository.findAll();
}

}

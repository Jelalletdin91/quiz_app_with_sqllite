package com.quizProject.demo.Controller;

import com.quizProject.demo.Entity.Users;
import com.quizProject.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class usersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/usersjson")
    public List<Users> users(){
        return usersService.getAllUsers();
    }



}

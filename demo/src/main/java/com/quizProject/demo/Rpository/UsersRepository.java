package com.quizProject.demo.Rpository;

import com.quizProject.demo.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}

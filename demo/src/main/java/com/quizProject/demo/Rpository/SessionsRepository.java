package com.quizProject.demo.Rpository;

import com.quizProject.demo.Entity.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionsRepository extends JpaRepository<Sessions, Integer> {

}

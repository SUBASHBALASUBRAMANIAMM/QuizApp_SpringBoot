package com.example.QuizApp_SpringBoot.Repository;

import com.example.QuizApp_SpringBoot.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
}

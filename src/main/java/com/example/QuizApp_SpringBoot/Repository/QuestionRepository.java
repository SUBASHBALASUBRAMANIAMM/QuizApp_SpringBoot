package com.example.QuizApp_SpringBoot.Repository;
import java.util.*;
import com.example.QuizApp_SpringBoot.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{

    List<Question> findByCategory(String category);

    @Query(
            value = "select * from question where category =:category order by rand() limit :numQ",nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int numQ);
}

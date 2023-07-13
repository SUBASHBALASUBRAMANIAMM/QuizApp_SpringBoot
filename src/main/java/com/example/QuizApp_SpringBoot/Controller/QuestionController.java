package com.example.QuizApp_SpringBoot.Controller;
import java.util.*;
import com.example.QuizApp_SpringBoot.Model.Question;
import com.example.QuizApp_SpringBoot.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("home")
    public String get(){
        return "string";
    }
@GetMapping("allQuestions")
    public List<Question> allQuestions(){
        return questionService.allQuestion();
    }
    @PostMapping("saveAllQuestions")
    public List<Question> saveAllQuestions(@RequestBody ArrayList<Question> questions){
    return questionService.saveAllQuestions(questions);
    }
    @GetMapping("category/{category}")
    public List<Question> findQuestionByCategory(@PathVariable("category") String category){
    return questionService.findQuestionByCategory(category);
    }

   @PostMapping("saveQuestion")
    public String saveQuestion(@RequestBody Question question){
            questionService.saveQuestion(question);
            return "successfully saved";
   }
   @PutMapping("updateQuestion/{id}")
   public Question updateQuestion(@PathVariable Long id,@RequestBody Question question){
        return questionService.updateQuestion(id,question);

   }
   @DeleteMapping("deleteQuestion/{id}")
   public String deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestion(id);
        return "deleted!";
   }

}

package com.example.QuizApp_SpringBoot.Controller;

import com.example.QuizApp_SpringBoot.Model.QuestionWrapper;
import com.example.QuizApp_SpringBoot.Model.Response;
import com.example.QuizApp_SpringBoot.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> get(@PathVariable Long id){
        return quizService.getQuizQuestion(id);

    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable("id") Long id, @RequestBody List<Response> response){
        return quizService.calcualateScore(id,response);
    }

//    @GetMapping("getQuiz")
//    public List<Object> getQuiz( ){
//        String url = "htts://opentdb.com/api.php?amount=10&category=20&difficulty=easy&type=multiple";
//        RestTemplate restTemplate = new RestTemplate();
//        Object[] quiz = restTemplate.getForObject(url,Object[].class);
//        return Arrays.asList(quiz);
//
//    }

}

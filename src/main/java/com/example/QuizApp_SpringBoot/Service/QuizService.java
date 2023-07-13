package com.example.QuizApp_SpringBoot.Service;

import com.example.QuizApp_SpringBoot.Model.Question;
import com.example.QuizApp_SpringBoot.Model.QuestionWrapper;
import com.example.QuizApp_SpringBoot.Model.Quiz;
import com.example.QuizApp_SpringBoot.Model.Response;
import com.example.QuizApp_SpringBoot.Repository.QuestionRepository;
import com.example.QuizApp_SpringBoot.Repository.QuizRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class QuizService {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepository.findRandomQuestionByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizRepository.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionfromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionWrapper = new ArrayList<>();
        for(Question q :questionfromDb){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionWrapper.add(qw);
        }
        return new ResponseEntity<>(questionWrapper,HttpStatus.OK);
    }


    public ResponseEntity<Integer> calcualateScore(Long id, List<Response> response) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int count =0;
        int i =0;
        for(Response r : response){
            if(r.getResponse().equals(questions.get(i).getRightAnswer())){
                count++;
            }
            i++;
        }
    return new ResponseEntity<>(count,HttpStatus.OK);
    }
}

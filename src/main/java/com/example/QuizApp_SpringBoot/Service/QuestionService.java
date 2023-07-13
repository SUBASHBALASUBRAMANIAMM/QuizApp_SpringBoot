package com.example.QuizApp_SpringBoot.Service;

import com.example.QuizApp_SpringBoot.Model.Question;
import com.example.QuizApp_SpringBoot.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
private QuestionRepository questionRepository;
    public List<Question> saveAllQuestions(ArrayList<Question> questions) {
        return questionRepository.saveAll(questions);
    }

    public List<Question> allQuestion() {
        return questionRepository.findAll();
    }

    public List<Question> findQuestionByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public void saveQuestion(Question question) {
         questionRepository.save(question);
    }

    public Question updateQuestion(Long id, Question question) {
        Question que = questionRepository.findById(id).get();

        if(question.getQuestionTitle() != null){
            que.setQuestionTitle(question.getQuestionTitle());
        }
        if(question.getOption1() != null){
            que.setOption1(question.getOption1());
        }
        if(question.getOption2() != null){
            que.setOption2(question.getOption2());
        }
        if(question.getOption3() != null){
            que.setOption3(question.getOption3());
        }
        if(question.getOption4() != null){
            que.setOption4(question.getOption4());
        }
        if(question.getCategory() != null){
            que.setCategory(question.getCategory());
        }
        if(question.getDifficultyLevel() != null){
            que.setDifficultyLevel(question.getDifficultyLevel());
        }
        if(question.getRightAnswer() != null){
            que.setRightAnswer(question.getRightAnswer());
        }
        questionRepository.save(que);
        return que;
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);


    }
}

package com.manisha.question_service.controller;

import com.manisha.question_service.model.Question;
import com.manisha.question_service.model.QuestionWrapper;
import com.manisha.question_service.model.Response;
import com.manisha.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService; // Use the injected instance, not a static reference

    @GetMapping("/allQuestions") // Added leading slash for the URL mapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return  questionService.getAllQuestions();
        // Call method on the instance, not statically

    }
    @GetMapping("category/{category}")
    public  ResponseEntity<List<Question>>getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addQuestion( @RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName , @RequestParam String numQuestions){
        return questionService.getQuestionForQuiz(categoryName,numQuestions);
    }
    @PostMapping("getQuestions")
            public ResponseEntity<List<QuestionWrapper>>getQuestionsFromId(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionsFromId(questionIds);
    }
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore (@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }

}

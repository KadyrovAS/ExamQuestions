package exam.pro.skyjava.course2.examineservice.controller;

import exam.pro.skyjava.course2.examineservice.model.Question;
import exam.pro.skyjava.course2.examineservice.service.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService questionService) {
        this.javaQuestionService = questionService;
    }

    @GetMapping("/java/{subject}add")
    public Question addQuestion(
            @PathVariable String subject,
            @RequestParam String question,
            @RequestParam String answer
    ){
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/java/{subject}remove")
    public String remove(
            @PathVariable String subject,
            @RequestParam String question,
            @RequestParam String answer
    ){
        Question q = javaQuestionService.remove(new Question(question, answer));
        if (q == null){
            return "Question not found";
        }else {
            return q.toString() + " was deleted";
        }
    }

    @GetMapping("/java")
    public Collection<Question> getAllQuestions(){
        return javaQuestionService.getAll();
    }
}

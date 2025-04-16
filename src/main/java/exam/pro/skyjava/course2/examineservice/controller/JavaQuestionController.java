package exam.pro.skyjava.course2.examineservice.controller;

import exam.pro.skyjava.course2.examineservice.model.Question;
import exam.pro.skyjava.course2.examineservice.service.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;
    private final String type = "java";

    public JavaQuestionController(JavaQuestionService questionRepository) {
        this.javaQuestionService = questionRepository;
    }

    @GetMapping("/add")
    public Question addQuestion(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer
    ){
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public String remove(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer
    ){
        Question q = javaQuestionService.remove(new Question(question, answer));
        if (q == null){
            return "Question not found";
        }else {
            return q.toString() + " was deleted";
        }
    }

    @GetMapping("")
    public Collection<Question> getAllQuestions(){
        return javaQuestionService.getAll();
    }

    @GetMapping("/find/{findLine}")
    public Collection<Question>find(@PathVariable("findLine") String findLine){
        return javaQuestionService.find(findLine);
    }
}

package exam.pro.skyjava.course2.examineservice.controller;

import exam.pro.skyjava.course2.examineservice.model.Question;
import exam.pro.skyjava.course2.examineservice.service.JavaQuestionService;
import exam.pro.skyjava.course2.examineservice.service.MathQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController{
    private final MathQuestionService mathQuestionService;
    private final String type = "math";

    public MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/add")
    public Question addQuestion(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer
    ){
        return mathQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public String remove(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer
    ){
        Question q = mathQuestionService.remove(new Question(question, answer));
        if (q == null){
            return "Question not found";
        }else {
            return q.toString() + " was deleted";
        }
    }

    @GetMapping("")
    public Collection<Question> getAllQuestions(){
        return mathQuestionService.getAll();
    }

    @GetMapping("/find/{findLine}")
    public Collection<Question>find(@PathVariable("findLine") String findLine){
        return mathQuestionService.find(findLine);
    }
}

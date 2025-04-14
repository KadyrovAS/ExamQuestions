package exam.pro.skyjava.course2.examineservice.controller;

import exam.pro.skyjava.course2.examineservice.model.Question;
import exam.pro.skyjava.course2.examineservice.service.QuestionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController{
    private final QuestionRepository questionRepository;
    private final String type = "math";

    public MathQuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/{subject}add")
    public Question addQuestion(
            @PathVariable String subject,
            @RequestParam String question,
            @RequestParam String answer
    ){
        return questionRepository.add(question, answer, type);
    }

    @GetMapping("/{subject}remove")
    public String remove(
            @PathVariable String subject,
            @RequestParam String question,
            @RequestParam String answer
    ){
        Question q = questionRepository.remove(new Question(question, answer, type));
        if (q == null){
            return "Question not found";
        }else {
            return q.toString() + " was deleted";
        }
    }

    @GetMapping("")
    public Collection<Question> getAllQuestions(){
        return questionRepository.getAll(type);
    }

    @GetMapping("/find/{findLine}")
    public Collection<Question>find(@PathVariable("findLine") String findLine){
        return questionRepository.find(findLine, type);
    }
}

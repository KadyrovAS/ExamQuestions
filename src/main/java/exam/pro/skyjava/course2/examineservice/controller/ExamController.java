package exam.pro.skyjava.course2.examineservice.controller;

import exam.pro.skyjava.course2.examineservice.model.Question;
import exam.pro.skyjava.course2.examineservice.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/java/get/{amount}")
    public Collection<Question> getQuestionsJava(@PathVariable("amount") int amount){
        return examinerService.getQuestions("java", amount);
    }

    @GetMapping("/math/get/{amount}")
    public Collection<Question> getQuestionsMath(@PathVariable("amount") int amount){
        return examinerService.getQuestions("math", amount);
    }
}

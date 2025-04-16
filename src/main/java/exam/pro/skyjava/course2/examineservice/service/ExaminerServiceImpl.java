package exam.pro.skyjava.course2.examineservice.service;

import exam.pro.skyjava.course2.examineservice.exception.NoEnoughQuestions;
import exam.pro.skyjava.course2.examineservice.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private JavaQuestionService javaQuestionService;
    private MathQuestionService mathQuestionService;


    public ExaminerServiceImpl(JavaQuestionService javaQuestionService,
                               MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public List<Question> getQuestions(int amount, String type) {
        QuestionServices services;
        if (type == "java"){
            services = javaQuestionService;
        }else{
            services = mathQuestionService;
        }
        Set<Question> questionsHasBeenSelected = new HashSet<>();

        if (amount > services.getAll().size()) {
            throw new NoEnoughQuestions(HttpStatus.BAD_REQUEST, "Превышено число вопросов!");
        } else if (amount == services.getAll().size()) {
            return services.getAll().stream().toList();
        }
        questionsHasBeenSelected.clear();
        while (questionsHasBeenSelected.size() < amount) {
            questionsHasBeenSelected.add(services.getRandomQuestion());
        }
        return questionsHasBeenSelected.stream().toList();
    }
}

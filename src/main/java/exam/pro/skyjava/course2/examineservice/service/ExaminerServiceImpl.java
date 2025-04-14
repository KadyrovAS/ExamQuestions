package exam.pro.skyjava.course2.examineservice.service;

import exam.pro.skyjava.course2.examineservice.exception.NoEnoughQuestions;
import exam.pro.skyjava.course2.examineservice.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Component
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;
    private Set<Question> questionsHasBeenSelected;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
        this.questionsHasBeenSelected = new HashSet<>();
    }

    @Override
    public List<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new NoEnoughQuestions(HttpStatus.BAD_REQUEST, "Превышено число вопросов!");
        } else if (amount == questionService.getAll().size()) {
            return questionService.getAll().stream().toList();
        }
        questionsHasBeenSelected.clear();
        while (questionsHasBeenSelected.size() < amount) {
            questionsHasBeenSelected.add(questionService.getRandomQuestion());
        }
        return questionsHasBeenSelected.stream().toList();
    }
}

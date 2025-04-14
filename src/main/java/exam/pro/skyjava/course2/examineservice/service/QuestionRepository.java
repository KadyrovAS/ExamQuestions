package exam.pro.skyjava.course2.examineservice.service;

import exam.pro.skyjava.course2.examineservice.model.Question;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Component
@Service
public class QuestionRepository implements QuestionService{
    private final Set<Question> questionSet;

    public QuestionRepository(){
        this.questionSet = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer, String type) {
        Question q = new Question(question, answer, type);
        this.questionSet.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {
        this.questionSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        this.questionSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll(String type) {
        return this.questionSet
                .stream()
                .filter(value->value.getType().equals(type))
                .toList();
    }

    @Override
    public Question getRandomQuestion(String type) {
        List<Question>listQuestions = this.questionSet
                .stream()
                .filter(value->value.getType().equals(type))
                .toList();

        if (listQuestions == null || listQuestions.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(listQuestions.size());

        return listQuestions.get(randomIndex);
    }

    @Override
    public List<Question> find(String findLine, String type) {
        return this.questionSet
                .stream()
                .filter(value->value.getType().equals(type) && value.getContext().contains(findLine))
                .toList();
    }
}

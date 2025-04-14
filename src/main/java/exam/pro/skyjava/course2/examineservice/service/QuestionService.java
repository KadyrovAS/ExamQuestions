package exam.pro.skyjava.course2.examineservice.service;

import exam.pro.skyjava.course2.examineservice.model.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionService {
    public Question add(String question, String answer, String type);

    public Question add(Question question);

    public Question remove(Question question);

    public Collection<Question> getAll(String type);

    public Question getRandomQuestion(String type);

    public List<Question> find(String findLine, String type);
}

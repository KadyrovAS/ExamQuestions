package exam.pro.skyjava.course2.examineservice.service;

import exam.pro.skyjava.course2.examineservice.model.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionServices{
    public Question add(String question, String answer);

    public Question add(Question question);

    public Question remove(Question question);

    public Collection<Question> getAll();

    public Question getRandomQuestion();

    public List<Question> find(String findLine);
}

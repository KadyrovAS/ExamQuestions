package exam.pro.skyjava.course2.examineservice.service;

import exam.pro.skyjava.course2.examineservice.model.Question;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Component
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
    }

    public List<Question> find(String findLine) {
        List<Question> questionList = new LinkedList<>();

        for (Question question : questions) {
            if (question.getContext().contains(findLine)) {
                questionList.add(question);
            }
        }
        return questionList;
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions == null || questions.isEmpty()) {
            return null;
        }

        ArrayList<Question> arrayListQuestion = new ArrayList<>(questions);
        Random random = new Random();
        int randomIndex = random.nextInt(arrayListQuestion.size());

        return arrayListQuestion.get(randomIndex);
    }
}
package exam.pro.skyjava.course2.examineservice.service;

import exam.pro.skyjava.course2.examineservice.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Random;
import java.util.Set;

import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class QuestionRepositoryTest {

    @Mock
    private Set<Question> questionSet;
    @Mock
    private Random random;
    @InjectMocks
    private QuestionRepository questionRepository;

    @Test
    public void givenQuestion_whenRemoveQuestion_thenCheckQuestionWasRemove() {
        String questionLine = "question01";
        String answerLine = "answer01";
        String type = "java";

        Question question = new Question(questionLine, answerLine, type);
        questionRepository.add(question);
        Question result = questionRepository.remove(question);

        Assertions.assertEquals(question, result);
    }

    @Test
    public void givenQuestionAndAnswer_whenFindQuestion_thenCheckQuestionExists() {
        String questionLine = "question02";
        String answerLine = "answer02";
        String type = "java";

        Question question = new Question(questionLine, answerLine, type);
        questionRepository.add(question);
        Collection<Question> result = questionRepository.find("question", type);

        Assertions.assertTrue(result.contains(question));
    }

    @Test
    public void givenQuestionAndAnswer_whenGetAllQuestions_thenCheckQuestionExists() {
        String questionLine = "question03";
        String answerLine = "answer03";
        String type = "java";

        Question question = new Question(questionLine, answerLine, type);
        questionRepository.add(question);
        Collection<Question> result = questionRepository.getAll(type);

        Assertions.assertTrue(result.contains(question));
    }

    @Test
    public void givenRandomQuestionAndAnswer_whenGetAllQuestions_thenCheckNotNullCollection() {
        String questionLine = "question04";
        String answerLine = "answer04";
        String type = "java";

        lenient().when(random.nextInt()).thenReturn(0);
        questionRepository.add(questionLine, answerLine, type);
        Question question = questionRepository.getRandomQuestion(type);

        Assertions.assertNotNull(question);
    }
}

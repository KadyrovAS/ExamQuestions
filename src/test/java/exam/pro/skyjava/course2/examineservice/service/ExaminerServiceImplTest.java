package exam.pro.skyjava.course2.examineservice.service;

import exam.pro.skyjava.course2.examineservice.exception.NoEnoughQuestions;
import exam.pro.skyjava.course2.examineservice.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void givenJavaQuestions_whenGetAllQuestions_thenCheckListSize() {
        lenient().when(javaQuestionService.getAll()).thenReturn(
                List.of(
                        new Question("questionJava01", "answerJava01"),
                        new Question("questionJava02", "answerJava02"),
                        new Question("questionJava03", "answerJava03"),
                        new Question("questionJava04", "answerJava04"),
                        new Question("questionJava05", "answerJava05")
                )
        );

        List<Question> list = examinerService.getQuestions(5, "java");

        Assertions.assertEquals(5, list.size());
    }

    @Test
    public void givenMathQuestions_whenGetAllQuestions_thenCheckListSize() {
        lenient().when(mathQuestionService.getAll()).thenReturn(
                List.of(
                        new Question("questionMath01", "answerMath01"),
                        new Question("questionMath02", "answerMath02"),
                        new Question("questionMath03", "answerMath03"),
                        new Question("questionMath04", "answerMath04"),
                        new Question("questionMath05", "answerMath05")
                )
        );

        List<Question> list = examinerService.getQuestions(5, "math");

        Assertions.assertEquals(5, list.size());
    }


    @Test
    public void givenSomeJavaQuestions_whenGetBiggerSizeQuestions_thenCheckException() {
        lenient().when(javaQuestionService.getAll()).thenReturn(
                List.of(
                        new Question("question_00", "answer_00")
                )
        );
        assertThrows(NoEnoughQuestions.class, () -> {
            examinerService.getQuestions(10, "java");
        });
    }

    @Test
    public void givenSomeMathQuestions_whenGetBiggerSizeQuestions_thenCheckException() {
        lenient().when(javaQuestionService.getAll()).thenReturn(
                List.of(
                        new Question("question_00", "answer_00")
                )
        );
        assertThrows(NoEnoughQuestions.class, () -> {
            examinerService.getQuestions(10, "math");
        });
    }

}

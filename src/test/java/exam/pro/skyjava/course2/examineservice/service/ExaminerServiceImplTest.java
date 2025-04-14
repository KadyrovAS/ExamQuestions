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
    private QuestionRepository questionRepositoryMock;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final String type = "java";

    @Test
    public void givenQuestions_whenGetAllQuestions_thenCheckListSize() {
        lenient().when(questionRepositoryMock.getAll(type)).thenReturn(
                List.of(
                        new Question("question01", "answer01", type),
                        new Question("question02", "answer02", type),
                        new Question("question03", "answer03", type),
                        new Question("question04", "answer04", type),
                        new Question("question05", "answer05", type)
                )
        );

        List<Question> list = examinerService.getQuestions(type, 5);

        Assertions.assertEquals(5, list.size());
    }

    @Test
    public void givenSomeQuestions_whenGetBiggerSizeQuestions_thenCheckException() {
        lenient().when(questionRepositoryMock.getAll(type)).thenReturn(
                List.of(
                        new Question("question_00", "answer_00", type)
                )
        );
        assertThrows(NoEnoughQuestions.class, () -> {
            examinerService.getQuestions(type, 10);
        });
    }
}

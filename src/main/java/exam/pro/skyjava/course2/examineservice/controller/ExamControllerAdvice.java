package exam.pro.skyjava.course2.examineservice.controller;

import exam.pro.skyjava.course2.examineservice.exception.NoEnoughQuestions;
import exam.pro.skyjava.course2.examineservice.exception.QuestionError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExamControllerAdvice {
    @ExceptionHandler(NoEnoughQuestions.class)
    public ResponseEntity<QuestionError>handleNoEnoughQuestions(NoEnoughQuestions e){
        QuestionError error = new QuestionError(e.getCode(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}

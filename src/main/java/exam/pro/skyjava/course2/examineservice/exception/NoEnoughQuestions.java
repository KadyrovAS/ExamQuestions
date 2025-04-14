package exam.pro.skyjava.course2.examineservice.exception;

import org.springframework.http.HttpStatus;

public class NoEnoughQuestions extends RuntimeException {
    private final HttpStatus code;

    public NoEnoughQuestions(HttpStatus code, String message) {
        super(message);
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }
}

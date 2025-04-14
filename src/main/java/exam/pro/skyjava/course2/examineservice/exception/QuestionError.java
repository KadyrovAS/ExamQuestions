package exam.pro.skyjava.course2.examineservice.exception;

import org.springframework.http.HttpStatus;

public class QuestionError {
    private final HttpStatus code;
    private final String message;


    public QuestionError(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpStatus getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

package exam.pro.skyjava.course2.examineservice.model;

import java.util.Objects;

public class Question {
    private final String question;
    private final String answer;
    private final String type;

    public Question(String question, String answer, String type) {
        this.question = question;
        this.answer = answer;
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getType() {
        return type;
    }

    public String getContext() {
        return question + " " + answer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) &&
                Objects.equals(answer, question1.answer) &&
                Objects.equals(type, question1.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer, type);
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}

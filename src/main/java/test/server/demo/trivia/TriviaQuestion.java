package test.server.demo.trivia;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TriviaQuestion {


    @Id
    private Integer id;

    private String question;

    private String answer;


    public TriviaQuestion() {
    }

    public TriviaQuestion(Integer id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

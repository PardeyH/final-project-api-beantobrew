package test.server.demo.trivia;

public class UserAnswer {

    private String userAnswer;

    private Double userScore;

    public UserAnswer() {
        this.userScore = 0.0;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public Double getUserScore() {
        return userScore;
    }

    public void setUserScore(Double userScore) {
        this.userScore = userScore;
    }

    public void addScore(double userScore) {
        this.userScore += userScore;
    }
}

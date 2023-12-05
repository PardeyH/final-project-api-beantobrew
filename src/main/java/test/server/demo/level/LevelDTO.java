package test.server.demo.level;

import jakarta.persistence.*;
import test.server.demo.trivia.TriviaDTO;
import test.server.demo.trivia.TriviaQuestion;

import java.util.List;

@Entity
public class LevelDTO {

    @Id
    private Integer id;

    private String levelPath;

    @OneToMany(mappedBy = "level")
    private List<TriviaDTO> triviaList;

    @OneToOne
    private TriviaQuestion triviaQuestion;

    public LevelDTO() {
    }

    public LevelDTO(Integer id, String levelPath, List<TriviaDTO> triviaList, TriviaQuestion triviaQuestion) {
        this.id = id;
        this.levelPath = levelPath;
        this.triviaList = triviaList;
        this.triviaQuestion = triviaQuestion;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelPath() {
        return levelPath;
    }

    public void setLevelPath(String levelPath) {
        this.levelPath = levelPath;
    }

    public List<TriviaDTO> getTriviaList() {
        return triviaList;
    }

    public void setTriviaList(List<TriviaDTO> triviaList) {
        this.triviaList = triviaList;
    }

    public TriviaQuestion getTriviaQuestion() {
        return triviaQuestion;
    }

    public void setTriviaQuestion(TriviaQuestion triviaQuestion) {
        this.triviaQuestion = triviaQuestion;
    }
}

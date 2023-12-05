package test.server.demo.trivia;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import test.server.demo.level.LevelDTO;

@Entity
public class TriviaDTO {


    @Id
    private Integer id;

    private String triviaText;

    @ManyToOne
    private LevelDTO level;

    @OneToOne
    private TriviaCoordinatesDTO triviaCoordinates;

    public TriviaDTO(Integer id, String triviaText, TriviaCoordinatesDTO triviaCoordinatesDTO) {
        this.id = id;
        this.triviaText = triviaText;
        this.triviaCoordinates = triviaCoordinatesDTO;
    }

    public TriviaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTriviaText() {
        return triviaText;
    }

    public void setTriviaText(String triviaText) {
        this.triviaText = triviaText;
    }

    public TriviaCoordinatesDTO getTriviaCoordinates() {
        return triviaCoordinates;
    }

    public void setTriviaCoordinates(TriviaCoordinatesDTO triviaCoordinates) {
        this.triviaCoordinates = triviaCoordinates;
    }
}
package test.server.demo.trivia;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TriviaCoordinatesDTO {

    @Id
    private Integer id;

    private Integer x1;

    private Integer y1;

    private Integer x2;

    private Integer y2;

    public TriviaCoordinatesDTO() {
    }

    public TriviaCoordinatesDTO(Integer id, Integer x1, Integer y1, Integer x2, Integer y2) {
        this.id = id;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getX1() {
        return x1;
    }

    public void setX1(Integer x1) {
        this.x1 = x1;
    }

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }
}

package test.server.demo.score;
import jakarta.persistence.*;
import test.server.demo.user.User;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Score() {}

    public Score(Integer score, User user) {
        this.score = score;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

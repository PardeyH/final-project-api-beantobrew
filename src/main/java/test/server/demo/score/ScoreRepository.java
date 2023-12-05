package test.server.demo.score;

import org.springframework.data.jpa.repository.JpaRepository;
import test.server.demo.user.User;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Integer> {
    List<Score> findByUser(User user);
}

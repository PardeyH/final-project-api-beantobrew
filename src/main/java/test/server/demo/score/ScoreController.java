package test.server.demo.score;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.server.demo.user.User;
import test.server.demo.user.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController

public class ScoreController {
    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;

    public ScoreController(ScoreRepository scoreRepository, UserRepository userRepository) {
        this.scoreRepository = scoreRepository;
        this.userRepository = userRepository;
    }


    public ResponseEntity<Score> saveScore( String userName, int correctnessPercentage ) {
        Optional<User> userOptional = userRepository.findByUserName(userName);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            Score newScore = new Score(correctnessPercentage, user);
            Score savedScore = scoreRepository.save(newScore);

            user.setCurrentScore(correctnessPercentage);
            userRepository.save(user);

            return ResponseEntity.ok(savedScore);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @GetMapping("/totalscore/{userName}")
    public ResponseEntity<Map<String, Object>> getTotalScore(@PathVariable String userName) {
        Optional<User> userOptional = userRepository.findByUserName(userName);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            List<Score> userScores = scoreRepository.findByUser(user);

            int totalScore = userScores.stream()
                    .mapToInt(Score::getScore)
                    .sum();


            String message1 = "";
            String message2 = "";
            String message3 = "";
            String message4 = "";
            String message5 = "";
            String image = "/images/framedPicture.png";

            if (totalScore >= 375 && totalScore <= 416) {
                message1 = "Knowledge Level: ";

                message2 = "Coffee Novice";

                message3 = "This certificate is hereby awarded to:";

                message4 = user.getUserName() ;

                message5 = "For the successful completion of the \"Coffee Tasting Course\" and the discovery of the wonderful world of coffee." +
                        "\n" +
                        "In recognition of your ability to distinguish between coffee and tea.";

            } else if (totalScore > 416 && totalScore <= 457) {
                message1 = "Knowledge Level: ";

                message2 = "Coffee Connoisseur";

                message3 = "This certificate is hereby awarded to:";

                message4 = user.getUserName() ;

                message5 = "For the successful completion and the expansion of your knowledge about the secrets of coffee.\n" +
                        "\n" +
                        "In recognition of your knack for the finest coffee beans and your talent for uncovering even the quirkiest coffee facts.";
            } else {
                message1 = "Knowledge Level:";

                message2 = "Coffee Expert";

                message3 = "This certificate is hereby awarded to:";

                message4 = user.getUserName();

                message5 = "For the impressive performance and unparalleled expertise in the world of coffee.\n" +
                        "\n" +
                        "In recognition of your ability to amaze even the most discerning coffee enthusiast.";
            }

            Map<String, Object> response = new HashMap<>();
            response.put("message1", message1);
            response.put("message2", message2);
            response.put("message3", message3);
            response.put("message4", message4);
            response.put("message5", message5);
            response.put("image", image);
            response.put("userName", userName);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

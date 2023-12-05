package test.server.demo.ai;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.server.demo.level.LevelCollection;
import test.server.demo.level.LevelDTO;
import test.server.demo.score.Score;
import test.server.demo.score.ScoreController;
import test.server.demo.trivia.UserAnswer;
import test.server.demo.user.User;
import test.server.demo.user.UserRepository;

import java.util.Map;
import java.util.Optional;


@RestController
public class AiController {

    final
    AiService aiService;

    private final LevelCollection levelCollection;

    private final UserRepository userRepository;
    private final ScoreController scoreController;


    public AiController(AiService aiService, UserRepository userRepository, ScoreController scoreController) {
        this.aiService = aiService;
        this.levelCollection = new LevelCollection();
        this.userRepository = userRepository;
        this.scoreController = scoreController;
    }

    @PostMapping(value = "/check-answer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> checkAnswer(@RequestBody Map<String, String> requestBody) {
        // Extract the levelId and userAnswer from the request body
        Integer levelId = Integer.parseInt(requestBody.get("levelId"));
        String userName = requestBody.get("userName");

        Optional<User> currentUser = userRepository.findByUserName(userName);

        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUserAnswer(requestBody.get("userAnswer"));

        // Retrieve the correct level by levelId
        LevelDTO level = levelCollection.getLevelById(levelId);

        if (level != null) {
            String correctAnswer = level.getTriviaQuestion().getAnswer();

            // Log the values for debugging
            System.out.println("Level ID: " + levelId);
            System.out.println("User Answer: " + userAnswer.getUserAnswer());
            System.out.println("Correct Answer: " + correctAnswer);

            // Construct a prompt for AI evaluation
            String promptToEvaluate = "The user gave the following answer " + userAnswer.getUserAnswer() +
                    " to the question " + level.getTriviaQuestion() + ". " +
                    "Evaluate the answer and give an approximate result in percent, how correct the userAnswer was. " +
                    "Please give the answer as JSON format with 'userAnswer: ' (" + userAnswer.getUserAnswer() + ") and " +
                    "'correctAnswer' (" + correctAnswer + ") " +
                    "and correctnessPercentage: 'make sure the percentage is given in integers'";


            // Call the AI service to evaluate the answer
            String aiResponse = aiService.prompt(promptToEvaluate);

            // Log the AI response for debugging
            System.out.println("AI Response: " + aiResponse);

            JsonObject aiResponseJson = JsonParser.parseString(aiResponse).getAsJsonObject();

            String correctnessPercentageStr = aiResponseJson.get("correctnessPercentage").getAsString();
            correctnessPercentageStr = correctnessPercentageStr.replace("%", ""); // Remove the percentage symbol
            try {
                double correctnessPercentage = Double.parseDouble(correctnessPercentageStr);

                if (correctnessPercentage >= 75) {
                    userAnswer.addScore(correctnessPercentage);
                    aiResponseJson.addProperty("correctnessPercentage", correctnessPercentage);//neu

                    ResponseEntity<Score> response = scoreController.saveScore(userName, (int) correctnessPercentage ); // Aufruf der saveScore Methode
                    if (response.getStatusCode() == HttpStatus.OK)
                        // If the correctness percentage is 75% or higher, consider it correct
                        return new ResponseEntity<>("Correct", HttpStatus.OK);
                } else {
                    aiResponseJson.addProperty("correctnessPercentage", correctnessPercentage);//neu
                    return new ResponseEntity<>("Incorrect", HttpStatus.OK);
                }
            } catch (NumberFormatException e) {
                // Handle parsing error
                return new ResponseEntity<>("AI response format error", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
package test.server.demo.level;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
public class LevelController {

    private final LevelCollection levelCollection;

    public LevelController() {
        this.levelCollection = new LevelCollection();
    }

    @GetMapping("/level/{levelId}")
    public ResponseEntity<LevelDTO> getLevelById(@PathVariable int levelId) {
        ArrayList<LevelDTO> levelList = levelCollection.getLevelList();
        for (LevelDTO level : levelList) {
            if (level.getId() == levelId) {
                // Return the LevelDTO object as JSON
                return new ResponseEntity<>(level, HttpStatus.OK);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No level found with this ID");
    }
}

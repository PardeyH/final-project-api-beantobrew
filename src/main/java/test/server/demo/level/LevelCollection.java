package test.server.demo.level;

import test.server.demo.trivia.TriviaCoordinatesDTO;
import test.server.demo.trivia.TriviaDTO;
import test.server.demo.trivia.TriviaQuestion;

import java.util.ArrayList;

public class LevelCollection {

    private ArrayList<LevelDTO> levelCollection = new ArrayList<>();

    public LevelCollection() {
        // Initialize Level 1
        ArrayList<TriviaDTO> triviaLevel1 = new ArrayList<>();

        triviaLevel1.add(new TriviaDTO(1,
                "Red Coffee Cherries: Did you know that the coffee bean is actually the seed inside a fruit known as a coffee cherry? The cherry turns red when it's ripe and ready for picking.",
                new TriviaCoordinatesDTO(1, 440, 580, 540, 640)));

        triviaLevel1.add(new TriviaDTO(2,
                "Manual Harvesting: Workers often manually harvest coffee cherries to ensure only ripe cherries are picked, as the quality of coffee can be affected by unripe cherries.",
                new TriviaCoordinatesDTO(2, 925, 390, 990, 460)));

        triviaLevel1.add(new TriviaDTO(3,
                "Basket of Fresh Cherries: A single coffee tree can produce up to 11 pounds of coffee cherries each year, which equates to roughly 2 pounds of green coffee beans.",
                new TriviaCoordinatesDTO(3, 320, 310, 540, 460)));

        this.levelCollection.add(new LevelDTO(1, "/images/level_1.png", triviaLevel1,
                new TriviaQuestion(1, "What is the color of a ripe coffee cherry?", "red")));
                // Answer: red

        // Initialize Level 2
        ArrayList<TriviaDTO> triviaLevel2 = new ArrayList<>();

        triviaLevel2.add(new TriviaDTO(4,
                "Sun-Drying: Laying coffee cherries out in the sun is one of the oldest and most natural methods of drying them. It can take up to 4 weeks for the cherries to fully dry.",
                new TriviaCoordinatesDTO(4, 240, 400, 440, 510)));

        triviaLevel2.add(new TriviaDTO(5,
                "Coffee Bags: Coffee is usually shipped in jute or sisal bags which allow the green beans to 'breathe'.",
                new TriviaCoordinatesDTO(5, 1340, 470, 1435, 570)));

        triviaLevel2.add(new TriviaDTO(6,
                "Shipping Crates: Some specialty coffee beans are even shipped in wooden crates to better preserve their quality.",
                new TriviaCoordinatesDTO(6, 680, 360, 930, 510)));

        this.levelCollection.add(new LevelDTO(2, "/images/level_2.png", triviaLevel2,
                new TriviaQuestion(2, "How long can it take for coffee cherries to fully dry in the sun?", "Up to 4 weeks")));
                // Answer: Up to 4 weeks

        // Initialize Level 3
        ArrayList<TriviaDTO> triviaLevel3 = new ArrayList<>();

        triviaLevel3.add(new TriviaDTO(7,
                "Drum Roaster: Drum roasters allow for a more even and controlled roasting process, which can bring out the nuanced flavors in the coffee beans.",
                new TriviaCoordinatesDTO(7, 380, 310, 650, 470)));

        triviaLevel3.add(new TriviaDTO(8,
                "Steam: The steam rising from the drum roaster is actually moisture being released from the green coffee beans during the roasting process.",
                new TriviaCoordinatesDTO(8, 1145, 400, 1240, 490)));

        triviaLevel3.add(new TriviaDTO(9,
                "Freshly Roasted Coffee: The first few days after roasting are critical for coffee beans as they emit carbon dioxide, which can affect the flavor if brewed too soon.",
                new TriviaCoordinatesDTO(9, 530, 670, 640, 730)));

        this.levelCollection.add(new LevelDTO(3, "/images/level_3.png", triviaLevel3,
                new TriviaQuestion(3, "What is the steam rising from the drum roaster?", "Moisture being released from the green coffee beans")));
                // Answer: Moisture being released from the green coffee beans

        // Initialize Level 4
        ArrayList<TriviaDTO> triviaLevel4 = new ArrayList<>();

        triviaLevel4.add(new TriviaDTO(10,
                "Fresh Cup of Coffee: A standard cup of black coffee contains about 95 milligrams of caffeine.",
                new TriviaCoordinatesDTO(10, 1205, 550, 1265, 625)));

        triviaLevel4.add(new TriviaDTO(11,
                "Sugar and Milk: Adding sugar and milk to coffee dates back hundreds of years and varies by cultural traditions.",
                new TriviaCoordinatesDTO(11, 200, 540, 270, 630)));

        triviaLevel4.add(new TriviaDTO(12,
                "Portafilter Machine: This machine forces hot water through finely-ground coffee under high pressure, which is the hallmark of espresso preparation.",
                new TriviaCoordinatesDTO(12, 360, 350, 700, 600)));

        this.levelCollection.add(new LevelDTO(4, "/images/level_4.png", triviaLevel4,
                new TriviaQuestion(4, "How much caffeine is in a standard cup of black coffee?", "About 95 milligrams.")));
                // Answer: About 95 milligrams

        // Initialize Level 5
        ArrayList<TriviaDTO> triviaLevel5 = new ArrayList<>();

        triviaLevel5.add(new TriviaDTO(13,
                "Coffee Mug: The average American consumes about 3 cups of coffee per day.",
                new TriviaCoordinatesDTO(13, 1060, 420, 1230, 555)));

        triviaLevel5.add(new TriviaDTO(14,
                "French Press: The French press method of brewing coffee allows for greater control over the brewing time and temperature.",
                new TriviaCoordinatesDTO(14, 840, 210, 1030, 510)));

        triviaLevel5.add(new TriviaDTO(15,
                "Ground Coffee: Coffee begins to lose its flavor within 30 minutes of being ground, which is why many coffee aficionados grind their beans just before brewing.",
                new TriviaCoordinatesDTO(15, 1005, 130, 1300, 225)));

        this.levelCollection.add(new LevelDTO(5, "/images/level_5.png", triviaLevel5,
                new TriviaQuestion(5, "How soon does coffee begin to lose its flavor after being ground?", "Within 30 minutes.")));
                // Answer: Within 30 minutes
    }

    public ArrayList<LevelDTO> getLevelList() {
        return this.levelCollection;
    }

    public ArrayList<LevelDTO> getLevelCollection() {
        return levelCollection;
    }

    public void setLevelCollection(ArrayList<LevelDTO> levelCollection) {
        this.levelCollection = levelCollection;
    }

    public LevelDTO getLevelById(Integer levelId) {
        for (LevelDTO level : levelCollection) {
            if (level.getId() == levelId) {
                return level;
            }
        }
        return null; // Return null if no level is found with the specified ID
    }
}

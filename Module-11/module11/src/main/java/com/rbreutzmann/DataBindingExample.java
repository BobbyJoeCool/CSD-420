package com.rbreutzmann;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * DataBindingExample.java
 *
 * Uses Jackson's Data Binding model (jackson-databind) to fetch the Ancient
 * Red Dragon from the Open5e API and deserialize it directly into a Java
 * object (a POJO called Monster).
 *
 * ObjectMapper does all the heavy lifting -- it maps each JSON field to the
 * matching field in the Monster class automatically.  @JsonIgnoreProperties
 * tells Jackson to skip any JSON fields that don't have a matching field in
 * the class, so we don't have to map every single field in the response.
 *
 * Endpoint: https://api.open5e.com/v1/monsters/ancient-red-dragon/
 */
public class DataBindingExample {

    // --- POJO that maps to the Open5e monster JSON ---
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Monster {

        public String name;
        public String size;
        public String type;

        @JsonProperty("challenge_rating")
        public String challengeRating;

        @JsonProperty("hit_points")
        public int hitPoints;

        @JsonProperty("hit_dice")
        public String hitDice;

        @JsonProperty("armor_class")
        public int armorClass;

        // Ability scores
        public int strength;
        public int dexterity;
        public int constitution;
        public int intelligence;
        public int wisdom;
        public int charisma;

        // Speed is a nested object in the JSON, so we map it to a simple
        // inner class.
        public Speed speed;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Speed {
            public String walk;
            public String fly;
        }

        // Convenience method to calculate an ability score modifier
        public static int modifier(int score) {
            return (int) Math.floor((score - 10) / 2.0);
        }

        // Prints a formatted stat block to the console
        public void printStatBlock() {
            System.out.println("==========================================");
            System.out.println("  " + name);
            System.out.println("  " + size + " " + type);
            System.out.println("==========================================");
            System.out.printf("  Challenge Rating : %s%n", challengeRating);
            System.out.printf("  Armor Class      : %d%n", armorClass);
            System.out.printf("  Hit Points       : %d (%s)%n", hitPoints, hitDice);
            if (speed != null) {
                System.out.printf("  Speed            : walk %s, fly %s%n",
                        speed.walk != null ? speed.walk : "—",
                        speed.fly  != null ? speed.fly  : "—");
            }
            System.out.println();
            System.out.println("  --- Ability Scores ---");
            System.out.printf("  STR: %2d (%+d)%n", strength,    modifier(strength));
            System.out.printf("  DEX: %2d (%+d)%n", dexterity,   modifier(dexterity));
            System.out.printf("  CON: %2d (%+d)%n", constitution, modifier(constitution));
            System.out.printf("  INT: %2d (%+d)%n", intelligence, modifier(intelligence));
            System.out.printf("  WIS: %2d (%+d)%n", wisdom,       modifier(wisdom));
            System.out.printf("  CHA: %2d (%+d)%n", charisma,     modifier(charisma));
            System.out.println("==========================================");
        }
    }

    // --- Main ---
    public static void main(String[] args) throws Exception {

        String url = "https://api.open5e.com/v1/monsters/ancient-red-dragon/";

        // Fetch the raw JSON string from the API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        // Deserialize the JSON into a Monster object with one line
        ObjectMapper mapper = new ObjectMapper();
        Monster dragon = mapper.readValue(json, Monster.class);

        // Now we can work with it as a normal Java object
        dragon.printStatBlock();
    }
}
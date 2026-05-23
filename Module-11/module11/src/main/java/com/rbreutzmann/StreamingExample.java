package com.rbreutzmann;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * StreamingExample.java
 *
 * Uses Jackson's low-level Streaming API (jackson-core) to fetch the Ancient
 * Red Dragon from the Open5e API and print a handful of stat-block fields.
 *
 * Because the Streaming API reads one token at a time, the program never
 * builds a full copy of the JSON in memory -- it just walks through the
 * token stream and picks out the fields it cares about.
 *
 * Endpoint: https://api.open5e.com/v1/monsters/ancient-red-dragon/
 */
public class StreamingExample {

    // Fields we want to pull from the JSON
    private static final String[] WANTED = {
        "name", "size", "type", "challenge_rating",
        "hit_points", "armor_class",
        "strength", "dexterity", "constitution",
        "intelligence", "wisdom", "charisma"
    };

    public static void main(String[] args) throws Exception {

        String url = "https://api.open5e.com/v1/monsters/ancient-red-dragon/";

        // --- Fetch the JSON from the API ---
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<InputStream> response =
                client.send(request, HttpResponse.BodyHandlers.ofInputStream());

        // --- Walk through the token stream with Jackson ---
        JsonFactory factory = new JsonFactory();

        try (JsonParser parser = factory.createParser(response.body())) {

            System.out.println("=== Ancient Red Dragon (Streaming API) ===\n");

            String currentField = null;

            while (!parser.isClosed()) {
                JsonToken token = parser.nextToken();

                if (token == null) break;

                // When we hit a field name, remember it
                if (token == JsonToken.FIELD_NAME) {
                    currentField = parser.getCurrentName();

                // When we hit a value and the field is one we want, print it
                } else if (token.isScalarValue() && currentField != null) {
                    if (isWanted(currentField)) {
                        System.out.printf("%-20s : %s%n",
                                currentField, parser.getText());
                    }
                    currentField = null;
                }
            }
        }
    }

    private static boolean isWanted(String fieldName) {
        for (String w : WANTED) {
            if (w.equals(fieldName)) return true;
        }
        return false;
    }
}
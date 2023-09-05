package org.sqa.api.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class JsonUtility {

    private static final Gson gson = new Gson();

    private JsonUtility() {
    }

    /**
     * Converts an object into its JSON representation using the Gson library.*
     *
     * @param o The object to be converted into JSON.
     * @return A JSON string representing the provided object.
     */
    public static String simpleJsonRequest(Object o) {
        return gson.toJson(o);
    }

    /**
     * Converts a JSON string into an object of the specified class using the Jackson ObjectMapper.*
     *
     * @param jsonString  A JSON string to be converted into an object.
     * @param chosenClass The target class to which the JSON data should be mapped.
     * @param <T>         The type of the target class.
     * @return An instance of the specified class populated with data from the JSON string.
     * @throws RuntimeException If there is an error during JSON deserialization, a RuntimeException is thrown
     *                          with the underlying JsonProcessingException as its cause.
     */
    public static <T> T convertJsonToObject(String jsonString, Class<T> chosenClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonString, chosenClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

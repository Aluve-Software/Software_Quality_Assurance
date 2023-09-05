package org.sqa.api.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class RestHelper {

    private RestHelper(){
    }

    private static final Gson gson = new Gson();

    public static String simpleJsonRequest(Object o){
        return gson.toJson(o);
    }

    public static <T> T convertJsonToObject(String jsonString, Class<T> chosenClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonString, chosenClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

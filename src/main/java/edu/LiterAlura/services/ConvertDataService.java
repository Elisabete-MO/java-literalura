package edu.LiterAlura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.LiterAlura.services.interfaces.IConvertData;

public class ConvertDataService implements IConvertData {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T fromJson(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }    }
}

package edu.LiterAlura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.LiterAlura.models.entities.BookEntity;
import edu.LiterAlura.models.records.Book;
import edu.LiterAlura.models.records.Books;
import edu.LiterAlura.services.interfaces.IConvertData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConvertDataService implements IConvertData {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T fromJson(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BookEntity> toBookEntities(Books books) {
        return books.books().stream()
                .map(this::toBookEntity)
                .collect(Collectors.toList());
    }

    private BookEntity toBookEntity(Book book) {
        return new BookEntity(book);
    }
}

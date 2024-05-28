package edu.LiterAlura.services;

import edu.LiterAlura.integration.BooksApiIntegration;
import edu.LiterAlura.models.records.Book;
import edu.LiterAlura.models.records.Books;
import org.springframework.stereotype.Component;

@Component
public class BooksService {
    private final BooksApiIntegration booksApiIntegration =
            new BooksApiIntegration();
    private final ConvertDataService convertService = new ConvertDataService();
    String ADDRESS = "https://gutendex.com/books/?";

    public Books getAllMediaDataByName(String bookName) {
        try {
            String endpoint =
                    ADDRESS + "search=" +bookName.toLowerCase().replace(" ",
                    "%20");
            String json = booksApiIntegration.getApiBooksData(endpoint);
            return convertService.fromJson(json, Books.class);
        } catch (Exception e) {
            throw new RuntimeException("Media not found" + e.getMessage());
        }
    }

    public Book getMediaDataById(String Id) {
        try {
            String endpoint =
                    ADDRESS + "ids=" + Id;
            String json = booksApiIntegration.getApiBooksData(endpoint);
            return convertService.fromJson(json, Book.class);
        } catch (Exception e) {
            throw new RuntimeException("Media not found" + e.getMessage());
        }
    }

}

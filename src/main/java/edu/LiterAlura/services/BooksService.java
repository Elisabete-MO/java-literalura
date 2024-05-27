package edu.LiterAlura.services;

import edu.LiterAlura.integration.BooksApiIntegration;
import edu.LiterAlura.models.records.Books;

public class BooksService {
    private final BooksApiIntegration booksApiIntegration =
            new BooksApiIntegration();
    private final ConvertDataService convertService = new ConvertDataService();
    String ADDRESS = "https://gutendex.com/books?search=";


    public Books getAllMediaDataByName(String bookName) {
        try {
            String endpoint = ADDRESS + bookName.replace(" ", "%20");
            String json = booksApiIntegration.getApiBooksData(endpoint);
            return convertService.fromJson(json, Books.class);
        } catch (Exception e) {
            throw new RuntimeException("Media not found" + e.getMessage());
        }
    }
}

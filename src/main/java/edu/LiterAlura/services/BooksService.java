package edu.LiterAlura.services;

import edu.LiterAlura.integration.BooksApiIntegration;
import edu.LiterAlura.models.entities.BookEntity;
import edu.LiterAlura.models.records.Book;
import edu.LiterAlura.models.records.Books;
import edu.LiterAlura.repositories.IBookRepository;
import org.springframework.stereotype.Component;

@Component
public class BooksService {
    private final IBookRepository repository;
    private final BooksApiIntegration booksApiIntegration;
    private final ConvertDataService convertService;
    String ADDRESS = "https://gutendex.com/books/?";

    public BooksService(IBookRepository repository,
                        BooksApiIntegration booksApiIntegration,
                        ConvertDataService convertService) {
        this.repository = repository;
        this.booksApiIntegration = booksApiIntegration;
        this.convertService = convertService;
    }

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

    public BookEntity getMediaDataById(String Id) {
        try {
            String endpoint =
                    ADDRESS + "ids=" + Id;
            String json = booksApiIntegration.getApiBooksData(endpoint);
            Books book = convertService.fromJson(json, Books.class);
            BookEntity bookEntity =
                    convertService.toBookEntities(book).getFirst();
            saveBook(bookEntity);
            return bookEntity;
        } catch (Exception e) {
            throw new RuntimeException("Media not found" + e.getMessage());
        }
    }

    public Books getAllMediaData(String language) {
        try {
            String endpoint =
                    ADDRESS + "languages=" + language;
            String json = booksApiIntegration.getApiBooksData(endpoint);
            return convertService.fromJson(json, Books.class);
        } catch (Exception e) {
            throw new RuntimeException("Media not found" + e.getMessage());
        }
    }

    public void saveBook(BookEntity bookEntity) {
         repository.save(bookEntity);
    }
}

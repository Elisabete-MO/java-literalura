package edu.LiterAlura.services;

import edu.LiterAlura.integration.BooksApiIntegration;
import edu.LiterAlura.models.entities.BookEntity;
import edu.LiterAlura.models.records.Books;
import edu.LiterAlura.repositories.IBookRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BooksService {
    private final IBookRepository booksRepository;
    private final BooksApiIntegration booksApiIntegration;
    private final ConvertDataService convertService;
    String ADDRESS = "https://gutendex.com/books/?";

    public BooksService(IBookRepository booksRepository,
                        BooksApiIntegration booksApiIntegration,
                        ConvertDataService convertService) {
        this.booksRepository = booksRepository;
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

    public List<BookEntity> getAllBooksFromDb() {
        try {
            return booksRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Media not found" + e.getMessage());
        }
    }

    public void saveBook(BookEntity bookEntity) {
         booksRepository.save(bookEntity);
    }
}

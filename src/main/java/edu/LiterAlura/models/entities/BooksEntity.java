package edu.LiterAlura.models.entities;

import edu.LiterAlura.models.records.Authors;
import edu.LiterAlura.models.records.Books;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class BooksEntity {
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToMany(mappedBy = "author", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<AuthorsEntity> authors = new ArrayList<>();

    @ElementCollection
    private List<String> languages = new ArrayList<>();
    private int downloads;

    /**
     * CONSTRUCTORS
     */
    public BooksEntity() {
    }

    public BooksEntity(final Books books) {
        this.id = (long) books.id();
        this.title = books.title();

        for (Authors author : books.authors()) {
            this.authors.add(new AuthorsEntity(author));
        }

        this.languages = books.languages();
        this.downloads = books.downloads();
    }

    /**
     * GETTERS AND SETTERS
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AuthorsEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorsEntity> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    /**
     * METHODS
     */
    @Override
    public String toString() {
        return "-----LIVRO-----" + '\n' +
                "Titulo: " + title + '\n' +
                "Autor: " + authors + '\n' +
                "Idioma: " + languages + '\n' +
                "Número de downloads: " + downloads + '\n' +
                "-----------------";
    }

}

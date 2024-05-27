package edu.LiterAlura.models.entities;

import edu.LiterAlura.models.records.Authors;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class AuthorsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "birth_year")
    private int birthYear;

    @Column(name = "death_year")
    private int deathYear;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<BooksEntity> books = new ArrayList<>();

    /**
     * CONSTRUCTORS
     */
    public AuthorsEntity() {
    }

    public AuthorsEntity(Authors authors) {
        this.name = authors.name();
        this.birthYear = authors.birthYear();
        this.deathYear = authors.deathYear();
    }

    /**
     * GETTERS AND SETTERS
     */
    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BooksEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BooksEntity> books) {
        this.books = books;
    }
}

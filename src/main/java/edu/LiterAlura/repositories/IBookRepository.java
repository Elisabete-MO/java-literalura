package edu.LiterAlura.repositories;

import edu.LiterAlura.models.entities.AuthorEntity;
import edu.LiterAlura.models.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<BookEntity, Long> {
}

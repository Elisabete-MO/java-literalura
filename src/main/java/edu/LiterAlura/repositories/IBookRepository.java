package edu.LiterAlura.repositories;

import edu.LiterAlura.models.entities.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<BooksEntity, Long> {
}

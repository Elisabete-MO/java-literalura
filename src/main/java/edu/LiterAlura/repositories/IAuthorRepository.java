package edu.LiterAlura.repositories;

import edu.LiterAlura.models.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<AuthorEntity, Long> {
}

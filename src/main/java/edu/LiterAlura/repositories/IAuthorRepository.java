package edu.LiterAlura.repositories;

import edu.LiterAlura.models.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface IAuthorRepository extends JpaRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> findFirstByName(String name);
}

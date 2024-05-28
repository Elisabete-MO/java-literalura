package edu.LiterAlura.repositories;

import edu.LiterAlura.models.entities.AuthorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorsRepository extends JpaRepository<AuthorsEntity, Long> {
}

package edu.LiterAlura.controllers.DTO;

import edu.LiterAlura.models.records.Author;

import java.util.List;

public record BookDTO(
        int id,
        String title,
        List<Author> authors,
        List<String> languages,
        int downloads
) {
}

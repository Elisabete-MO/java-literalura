package edu.LiterAlura.controllers.DTO;

import edu.LiterAlura.models.records.Authors;

import java.util.List;

public record BookDTO(
        int id,
        String title,
        List<Authors> authors,
        List<String> languages,
        int downloads
) {
}

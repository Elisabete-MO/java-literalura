package edu.LiterAlura.models.records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.LiterAlura.models.entities.AuthorsEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Authors(
        @JsonProperty("name") String name,
        @JsonProperty("birth_year") int birthYear,
        @JsonProperty("death_year") int deathYear
) {
    public AuthorsEntity toEntity() {
        return new AuthorsEntity(this);
    }
}

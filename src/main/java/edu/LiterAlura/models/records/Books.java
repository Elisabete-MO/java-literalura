package edu.LiterAlura.models.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Books(
        @JsonProperty("id") int id,
        @JsonProperty("title") String title,
        @JsonProperty("authors") List<Authors> authors,
        @JsonProperty("languages") List<String> languages,
        @JsonAlias("download_count") int downloads
) {}

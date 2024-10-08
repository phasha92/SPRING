package org.example.model.dto;

import java.util.List;

public record FilmDTO(int id, String title, int releaseYear, List<String> actorNames, String directorName){}
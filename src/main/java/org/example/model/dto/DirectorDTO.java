package org.example.model.dto;

import java.util.List;

public record DirectorDTO(int id, String name, List<String> filmTitles) {}
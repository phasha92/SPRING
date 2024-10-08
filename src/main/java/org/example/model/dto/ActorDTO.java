package org.example.model.dto;

import java.util.List;

public record ActorDTO(int id, String name, List<String> filmTitles){}
package org.example.mapper;

import org.example.model.dto.DirectorDTO;
import org.example.model.entity.Director;
import org.example.model.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DirectorMapper {

    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);

    @Mapping(target = "filmTitles", source = "films")
    DirectorDTO toDTO(Director director);

    @Mapping(target = "films", ignore = true)
    Director toEntity(DirectorDTO directorDTO);

    default List<String> mapFilmsToTitles(List<Film> films) {
        return films.stream()
                .map(Film::getTitle)
                .toList();
    }
}
package org.example.mapper;

import org.example.model.dto.FilmDTO;
import org.example.model.entity.Actor;
import org.example.model.entity.Director;
import org.example.model.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FilmMapper {

    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

    @Mapping(target = "directorName", source = "director.name")
    @Mapping(target = "actorNames", source = "actors")
    FilmDTO toDTO(Film film);

    @Mapping(target = "actors", ignore = true)
    @Mapping(target = "director", source = "directorName")
    Film toEntity(FilmDTO filmDTO);

    default List<String> mapActorsToNames(List<Actor> actors) {
        return actors.stream()
                .map(Actor::getName)
                .toList();
    }

    default Director map(String directorName) {
        Director director = new Director();
        director.setName(directorName);
        return director;
    }
}
package org.example.mapper;

import org.example.model.dto.ActorDTO;
import org.example.model.entity.Actor;
import org.example.model.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ActorMapper {

    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    @Mapping(target = "filmTitles", source = "films")
    ActorDTO toDTO(Actor actor);

    @Mapping(target = "films", ignore = true)
    Actor toEntity(ActorDTO actorDTO);

    default List<String> mapFilmsToTitles(List<Film> films) {
        return films.stream()
                .map(Film::getTitle)
                .toList();
    }
}
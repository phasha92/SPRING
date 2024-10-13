package org.example.mapper;

import org.example.dto.ActorDTO;
import org.example.entity.Actor;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

@Mapper
public interface ActorMapper {

    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    ActorDTO toActorDTO(Actor actor);

    Actor toActor(ActorDTO actorDTO);
}

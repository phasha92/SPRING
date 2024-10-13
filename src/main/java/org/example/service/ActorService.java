package org.example.service;

import org.example.dto.ActorDTO;
import org.example.entity.Actor;
import org.example.mapper.ActorMapper;
import org.example.repository.ActorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private Logger logger = LoggerFactory.getLogger(ActorService.class);

    @Autowired
    private ActorRepository actorRepository;

    public List<ActorDTO> getAllActors() {
        logger.info("getAllActors");
        return actorRepository.findAll().stream().map(ActorMapper.INSTANCE::toActorDTO).toList();

    }

    public ActorDTO getActor(Integer id) {
        logger.info("getActor");
        return ActorMapper.INSTANCE.toActorDTO(actorRepository.getOne(id));
    }

    public void addActor(ActorDTO actorDTO) {
        logger.info("addActor");
        actorRepository.save(ActorMapper.INSTANCE.toActor(actorDTO));
    }

}

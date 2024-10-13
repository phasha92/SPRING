package org.example.controller;

import org.example.dto.ActorDTO;
import org.example.entity.Actor;
import org.example.mapper.ActorMapper;
import org.example.service.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/actors/*")
public class ActorController {

    private Logger logger = LoggerFactory.getLogger(ActorController.class);

    @Autowired
    private ActorService actorService;

    @Autowired
    ActorMapper ma;

    @GetMapping("/get/{id}")
    public ActorDTO get(@PathVariable Integer id) {
        logger.info("Get actor with id: " + id);
        return actorService.getActor(id);
    }

    @PostMapping("/")
    public void add(@RequestBody ActorDTO actorDTO) {
        logger.info("Add actor: " + actorDTO.toString());
        actorService.addActor(actorDTO);
    }

    @GetMapping("/")
    public List<ActorDTO> getAll() {
        logger.info("Get all actors");
        return actorService.getAllActors();
    }

    @GetMapping("/test")
    public String test() {
        logger.info("Test");
        return "!!!!!!!!!!!!!!!!!!!!!!!!!";
    }

}

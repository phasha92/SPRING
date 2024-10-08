package org.example;

import org.example.dao.AppConfig;
import org.example.dao.DBManagerConnection;

import org.example.mapper.ActorMapper;
import org.example.mapper.DirectorMapper;
import org.example.mapper.FilmMapper;
import org.example.model.dto.ActorDTO;
import org.example.model.dto.DirectorDTO;
import org.example.model.dto.FilmDTO;
import org.example.model.entity.Actor;
import org.example.model.entity.Director;
import org.example.model.entity.Film;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DBManagerConnection connection = context.getBean(DBManagerConnection.class);
        System.out.println(connection.getConnection() == null);

        Actor actor = new Actor();
        Film film = new Film();
        Director director = new Director();

        actor.setName("Vasya");
        film.setTitle("menyaet profession");
        director.setName("my name is anton");

        String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W"};

        String[] titles = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};

        Random rnd = new Random();

        List<Actor> actors = new ArrayList<>();
        List<Film> films = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Actor a = new Actor();
            a.setName(names[rnd.nextInt(names.length)]);
            actors.add(a);

            Film f = new Film();
            f.setTitle(titles[rnd.nextInt(titles.length)]);
            films.add(f);
        }
        actor.setFilms(films);
        film.setActors(actors);
        film.setDirector(director);
        director.setFilms(films);

        ActorDTO actorDTO = ActorMapper.INSTANCE.toDTO(actor);
        FilmDTO filmDTO = FilmMapper.INSTANCE.toDTO(film);
        DirectorDTO directorDTO = DirectorMapper.INSTANCE.toDTO(director);

        System.out.println(actor + " toDTO -> " + actorDTO);
        System.out.println(film + " toDTO -> " + filmDTO);
        System.out.println(director + " toDTO -> " + directorDTO);

        System.out.println(actorDTO+" toEntity -> " + ActorMapper.INSTANCE.toEntity(actorDTO));
        System.out.println(filmDTO+" toEntity -> " + FilmMapper.INSTANCE.toEntity(filmDTO));
        System.out.println(directorDTO+" toEntity -> " + DirectorMapper.INSTANCE.toEntity(directorDTO));
    }
}

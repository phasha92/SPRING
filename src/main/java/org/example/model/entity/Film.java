package org.example.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "film")  
public class Film extends AbstractEntity {

    @Column(name = "title") 
    private String title;

    @Column(name = "release_year") 
    private int releaseYear;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "film_actor", 
            joinColumns = @JoinColumn(name = "film_id"), 
            inverseJoinColumns = @JoinColumn(name = "actor_id") 
    )
    private List<Actor> actors = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id") 
    private Director director;

    public Film(int id, String title, int releaseYear, List<Actor> actors, Director director) {
        super(id);
        this.title = title;
        this.releaseYear = releaseYear;
        this.actors = actors != null ? new ArrayList<>(actors) : new ArrayList<>();
        this.director = director != null ? director : new Director();
    }

    public Film() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Actor> getActors() {
        return Collections.unmodifiableList(actors);
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors != null ? actors : new ArrayList<>();
    }

    public Director getDirector() {
        return director != null ? director : new Director();
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", actors=" + actors +
                ", director=" + director +
                ", id=" + id +
                '}';
    }
}

package org.example.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "actor")
public class Actor extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "actors", cascade = CascadeType.ALL)
    private List<Film> films = new ArrayList<>();

    public Actor(int id, String name, List<Film> films) {
        super(id);
        this.name = name;
        this.films = films != null ? new ArrayList<>(films) : new ArrayList<>();
    }

    public Actor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFilms(List<Film> films) {
        this.films = films != null ? films : new ArrayList<>();
    }

    public List<Film> getFilms() {
        return Collections.unmodifiableList(films);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", films=" + films +
                ", id=" + id +
                '}';
    }
}
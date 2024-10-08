package org.example.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "director")
public class Director extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
    private List<Film> films = new ArrayList<>();

    public Director(int id, String name, List<Film> films) {
        super(id);
        this.name = name;
        this.films = films != null ? films : new ArrayList<>();
    }

    public Director() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Film> getFilms() {
        return Collections.unmodifiableList(films);
    }

    public void setFilms(List<Film> films) {
        this.films = films != null ? films : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", films=" + films +
                ", id=" + id +
                '}';
    }
}
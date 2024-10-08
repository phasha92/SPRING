package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "actor")
public class Actor extends AbstractEntity {

    @Column
    private String name;

    @ManyToMany(mappedBy = "actor")
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

    // Возвращаем неизменяемый список
    public List<Film> getFilms() {
        return Collections.unmodifiableList(films);  // Возвращаем неизменяемый список
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return id == actor.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
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

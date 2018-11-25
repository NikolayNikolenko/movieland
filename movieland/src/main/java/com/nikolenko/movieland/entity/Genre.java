package com.nikolenko.movieland.entity;

import java.util.Objects;

public class Genre {
    private int id;
    private String Name;

    public Genre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return id == genre.id &&
                Objects.equals(Name, genre.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name);
    }
}

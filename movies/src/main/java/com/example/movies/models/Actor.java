package com.example.movies.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable=false)
    String name;
    @Column(nullable = false)
    String surname;
    @ManyToMany(mappedBy="actors")
    List<Movie> actor;
    @OneToMany(mappedBy = "director")
    List<Movie> director;
    @OneToMany(mappedBy = "writer")
    List<Movie> writer;
}

package com.example.movies.models;

import jakarta.persistence.*;


import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable=false, length = 100)
    String title;
    @Column(nullable=false)
    int year;
    LocalDate released;
    int runtime;
    @Column(length = 1000)
    String plot;
    String awards;
    @Column(length=500)
    String poster;
    @Column(name="imdb_rating")
    float imdbRating;
    @ManyToMany
    @JoinTable(name = "genre_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genres_id"))
    List<Genre> genres;
    @ManyToMany
    @JoinTable(name = "actor_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actors_id"))
    List<Actor> actors;
    @ManyToMany
    @JoinTable(name = "language_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "languages_id"))
    List<Language> languages;
    @ManyToMany
    @JoinTable(name = "country_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "countries_id"))
    List<Country> countries;
    @ManyToOne @JoinColumn(name="director_id")
    Actor director;
    @ManyToOne @JoinColumn(name="writer_id")
    Actor writer;



    //actors="Leonardo DiCaprio, Kate Winslet, Billy Zane" Many to Many
    //language="English, Swedish, Italian, French"
    //country="United States, Mexico"
}

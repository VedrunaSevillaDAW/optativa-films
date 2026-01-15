package com.vedruna.filmsmicroservice.domain.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FilmModel {
    Integer filmId;
    String title;
    LocalDate releaseDate;
    String poster;
    Boolean inCinemas;
    Float rating;
}

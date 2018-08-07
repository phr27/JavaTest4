package com.hand.api.service;

import com.hand.domain.entity.Film;

public interface FilmService {

    boolean addFilm(Film film);

    boolean addFilmTestTxManager(Film film);
}

package com.hand.api.service.impl;

import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import com.hand.infra.mapper.FilmMapper;

public class FilmServiceImpl implements FilmService {

    private FilmMapper filmMapper;

    @Override
    public boolean addFilm(Film film) {
        return filmMapper.insertFilm(film) != 0;
    }

    @Override
    public boolean addFilmTestTxManager(Film film) {
        filmMapper.insertFilm(film);
        throw new RuntimeException("for test");
    }

    public void setFilmMapper(FilmMapper filmMapper) {
        this.filmMapper = filmMapper;
    }
}

package com.hand.infra.mapper;

import com.hand.domain.entity.Film;
import org.apache.ibatis.annotations.Param;

public interface FilmMapper {

    int insertFilm(@Param("film") Film film);
}

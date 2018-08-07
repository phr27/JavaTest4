package com.hand;

import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import com.hand.domain.entity.RatingEnum;
import com.hand.domain.entity.SpecialFeature;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;

public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        String title = System.getenv("TITLE");
        System.out.println("Film title: ");
        System.out.println(title);
        String description = System.getenv("DESCRIPTION");
        System.out.println("Film description: ");
        System.out.println(description);
        Integer languageId = Integer.parseInt(System.getenv("LANGUAGE_ID"));
        System.out.println("Film languageId: ");
        System.out.println(languageId);

        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setLanguageId(languageId);
        film.setReleaseYear("2018");
        film.setRentalDuration(6);
        film.setRentalRate(0.5);
        film.setLength(100);
        film.setReplacementCost(20.5);
        film.setRating(RatingEnum.PG);
        film.setSpecialFeatures(new HashSet<SpecialFeature>() {{
            add(SpecialFeature.COMMENTARIES);
            add(SpecialFeature.BEHIND_THE_SCENES);
        }});

        FilmService filmService = applicationContext.getBean("filmService", FilmService.class);

        try {
            if (args.length != 0 && "test".equalsIgnoreCase(args[0])) {
                System.out.println("insert success: " + filmService.addFilmTestTxManager(film));
            } else {
                System.out.println("insert success: " + filmService.addFilm(film));
            }
        } catch (Exception e) {
            System.err.println(e.getClass() + ": " + e.getMessage());
        } finally {
            ((ClassPathXmlApplicationContext) applicationContext).close();
        }
    }
}

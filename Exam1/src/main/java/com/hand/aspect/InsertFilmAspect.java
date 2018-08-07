package com.hand.aspect;

public class InsertFilmAspect {

    public void beforeInsertFilmEvent() {
        System.out.println("Before Insert Film Data");
    }

    public void afterInsertFilmEvent() {
        System.out.println("After Insert Film Data");
    }
}

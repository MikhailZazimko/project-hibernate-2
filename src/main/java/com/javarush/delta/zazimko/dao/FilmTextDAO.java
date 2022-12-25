package com.javarush.delta.zazimko.dao;

import com.javarush.delta.zazimko.entity.FilmText;
import org.hibernate.SessionFactory;

public class FilmTextDAO extends UniversalDAO<FilmText>{
    public FilmTextDAO(SessionFactory sessionFactory) {
        super(sessionFactory, FilmText.class);
    }
}

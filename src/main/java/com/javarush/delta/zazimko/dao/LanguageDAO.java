package com.javarush.delta.zazimko.dao;

import com.javarush.delta.zazimko.entity.Language;
import org.hibernate.SessionFactory;

public class LanguageDAO extends UniversalDAO<Language> {

    public LanguageDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Language.class);
    }
}

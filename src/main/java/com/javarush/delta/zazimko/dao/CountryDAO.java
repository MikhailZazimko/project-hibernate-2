package com.javarush.delta.zazimko.dao;

import com.javarush.delta.zazimko.entity.Country;
import org.hibernate.SessionFactory;

public class CountryDAO extends UniversalDAO<Country> {

    public CountryDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Country.class);
    }
}

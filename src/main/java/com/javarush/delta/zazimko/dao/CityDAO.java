package com.javarush.delta.zazimko.dao;

import com.javarush.delta.zazimko.entity.City;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CityDAO extends UniversalDAO<City>{
    public CityDAO(SessionFactory sessionFactory) {
        super(sessionFactory, City.class);
    }

    public City getByName(String changzhou) {
        Query<City> query = getCurrentSession()
                .createQuery("select  city from City city where city.cityName=:name", City.class);
        query.setParameter("name",changzhou);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}

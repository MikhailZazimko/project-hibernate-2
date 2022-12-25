package com.javarush.delta.zazimko.dao;

import com.javarush.delta.zazimko.entity.Rental;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class RentalDAO extends UniversalDAO<Rental> {
    public RentalDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Rental.class);
    }

    public Rental findNotReturnedRental() {
        Query<Rental> query = getCurrentSession()
                .createQuery("select r from Rental r where r.returnDate is null", Rental.class);
       query.setMaxResults(1);
       return query.getSingleResult();
    }
}

package com.javarush.delta.zazimko.dao;

import com.javarush.delta.zazimko.entity.Address;
import org.hibernate.SessionFactory;

public class AddressDAO extends UniversalDAO<Address> {

    public AddressDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Address.class);
    }
}

package com.javarush.delta.zazimko.dao;

import com.javarush.delta.zazimko.entity.Store;
import org.hibernate.SessionFactory;

public class StoreDAO extends UniversalDAO<Store> {
    public StoreDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Store.class);
    }
}

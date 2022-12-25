package com.javarush.delta.zazimko.dao;

import com.javarush.delta.zazimko.entity.Inventory;
import org.hibernate.SessionFactory;

public class InventoryDAO extends UniversalDAO<Inventory> {
    public InventoryDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Inventory.class);
    }
}


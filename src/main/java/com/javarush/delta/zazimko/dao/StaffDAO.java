package com.javarush.delta.zazimko.dao;

import com.javarush.delta.zazimko.entity.Staff;
import org.hibernate.SessionFactory;

public class StaffDAO extends UniversalDAO<Staff> {

    public StaffDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Staff.class);
    }
}

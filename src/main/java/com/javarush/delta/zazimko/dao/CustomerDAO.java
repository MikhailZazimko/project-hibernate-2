package com.javarush.delta.zazimko.dao;

import com.javarush.delta.zazimko.entity.Customer;
import org.hibernate.SessionFactory;

public class CustomerDAO extends UniversalDAO<Customer> {
    public CustomerDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Customer.class);
    }
}

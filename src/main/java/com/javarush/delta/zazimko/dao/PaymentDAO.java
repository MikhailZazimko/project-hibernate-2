package com.javarush.delta.zazimko.dao;

import com.javarush.delta.zazimko.entity.Payment;
import org.hibernate.SessionFactory;

public class PaymentDAO extends UniversalDAO<Payment> {

    public PaymentDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Payment.class);
    }
}

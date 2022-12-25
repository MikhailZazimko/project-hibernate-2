package com.javarush.delta.zazimko.dao;

import com.javarush.delta.zazimko.entity.Actor;
import org.hibernate.SessionFactory;

public class ActorDAO extends UniversalDAO<Actor> {

    public ActorDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Actor.class);
    }
}

package com.javarush.delta.zazimko.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public abstract class UniversalDAO<T> {
    private final SessionFactory sessionFactory;
    private final Class<T> clazz;

    public UniversalDAO(SessionFactory sessionFactory, Class<T> clazz) {
        this.sessionFactory = sessionFactory;
        this.clazz = clazz;
    }

    public T getById(int id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    public List<T> getItems(int offset, int limit) {
        Query<T> query = getCurrentSession()
                .createQuery("from " + clazz.getName(), clazz);

        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    public List<T> findAll() {
        Query<T> query = getCurrentSession()
                .createQuery("from " + clazz.getName(), clazz);
        return query.list();
    }

    public T save(T t) {
        try (Session session = getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            transaction.commit();
            return t;
        }
    }

    public T update(T t) {
        try (Session session = getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(t);
            transaction.commit();
            return t;
        }
    }

    public void delete(T t) {
        try (Session session = getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(t);
            transaction.commit();
        }
    }
    public void deleteById(int id) {
        T t = getCurrentSession().get(clazz, id);
        delete(t);
    }
    public Session getCurrentSession(){
        return sessionFactory.openSession();
    }

}

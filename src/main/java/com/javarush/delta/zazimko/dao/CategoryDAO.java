package com.javarush.delta.zazimko.dao;

import com.javarush.delta.zazimko.entity.Category;
import org.hibernate.SessionFactory;

public class CategoryDAO extends UniversalDAO<Category> {

    public CategoryDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Category.class);
    }
}

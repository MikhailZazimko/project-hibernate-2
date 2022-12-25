package com.javarush.delta.zazimko;

import com.javarush.delta.zazimko.controllers.HibernateStarter;
import com.javarush.delta.zazimko.entity.Customer;

public class Main {


    public static void main(String[] args) {
        HibernateStarter starter = new HibernateStarter();
        Customer customer = starter.createCustomer();
        starter.returnInventory();
        starter.customerMakeRent(customer);
        starter.newFilmToRental();
    }
}
package com.javarush.delta.zazimko.controllers;

import com.javarush.delta.zazimko.dao.*;
import com.javarush.delta.zazimko.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class HibernateStarter {
    private final SessionFactory sessionFactory;
    private final ActorDAO actorDAO;
    private final AddressDAO addressDAO;
    private final CategoryDAO categoryDAO;
    private final CityDAO cityDAO;
    private final CountryDAO countryDAO;
    private final CustomerDAO customerDAO;
    private final FilmDAO filmDAO;
    private final FilmTextDAO filmTextDAO;
    private final InventoryDAO inventoryDAO;
    private final LanguageDAO languageDAO;
    private final PaymentDAO paymentDAO;
    private final RentalDAO rentalDAO;
    private final StaffDAO staffDAO;
    private final StoreDAO storeDAO;

    public HibernateStarter() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.DRIVER, "com.p6spy.engine.spy.P6SpyDriver");
        properties.put(Environment.URL, "jdbc:p6spy:mysql://localhost:3306/movie");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "validate");

        sessionFactory = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(FilmText.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Store.class)
                .setProperties(properties)
                .buildSessionFactory();


        actorDAO = new ActorDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        filmTextDAO = new FilmTextDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);
    }

    public Customer createCustomer() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Store store = storeDAO.getItems(0, 1).get(0);
            City city = cityDAO.getByName("Changzhou");
            Address address = new Address();
            address.setAddressName("Gagarina");
            address.setPhone("4313135511");
            address.setCity(city);
            address.setDistrictName("Central park");
            addressDAO.save(address);
            Customer customer = new Customer();
            customer.setAddress(address);
            customer.setFirstName("Vasily");
            customer.setLastName("Shevchenko");
            customer.setIsActive(true);
            customer.setEmail("vasilyShev@mail.ru");
            customer.setStore(store);
            customerDAO.save(customer);
            transaction.commit();
            return customer;
        }
    }

    public void returnInventory() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Rental rental = rentalDAO.findNotReturnedRental();

            rental.setReturnDate(LocalDateTime.now());
            rentalDAO.save(rental);

            transaction.commit();
        }
    }

    public void customerMakeRent(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Film film = filmDAO.getFirstAvailableForRent();
            Inventory inventory = new Inventory();
            Store store = storeDAO.getItems(0, 1).get(0);
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDAO.save(inventory);
            Staff staff = store.getStaffManager();

            Rental rental = new Rental();
            rental.setInventory(inventory);
            rental.setRentalDate(LocalDateTime.now());
            rental.setCustomer(customer);
            rental.setStaff(staff);
            rentalDAO.save(rental);
            Payment payment = new Payment();
            payment.setCustomer(customer);
            payment.setPaymentDate(LocalDateTime.now());
            payment.setStaff(staff);
            payment.setRental(rental);
            payment.setAmount(BigDecimal.valueOf(55.99));
            paymentDAO.save(payment);
            transaction.commit();
        }
    }

    public void newFilmToRental() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Language language = languageDAO.getItems(0, 20).stream()
                    .unordered().findAny().get();
            List<Category> categories = categoryDAO.getItems(0, 5);
            List<Actor> actors = actorDAO.getItems(0, 20);
            Film film = new Film();
            film.setActors(actors);
            film.setCategories(categories);
            film.setDescription("бла бла бла");
            film.setLanguage(language);
            film.setRating(Rating.PG);
            film.setSpecialFeatures(Set.of(Features.BEHIND_THE_SCENES, Features.DELETED_SCENES,Features.TRAILERS));
            film.setLenght((short)120);
            film.setOriginalLanguage(language);
            film.setReplacementCost(BigDecimal.valueOf(100));
            film.setTitle("JavaRush is coming!");
            film.setYear(Year.of(2022));
            film.setRentalRate(BigDecimal.valueOf(4,4));
            film.setRentalDuration((byte)29 );
            filmDAO.save(film);

            FilmText filmText = new FilmText();
            filmText.setFilm(film);
            filmText.setDescription("бла бла бла");
            filmText.setTitle("JavaRush is coming!");
            filmText.setId(film.getId());
            filmTextDAO.save(filmText);




            transaction.commit();

        }
    }
}

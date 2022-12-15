package sessionFactory;

import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class HibernateMySQLUtil {
    private static HibernateMySQLUtil instance;
    static Properties mysqlProperties;
    private final SessionFactory sessionFactory;

    private HibernateMySQLUtil() {
        initialiseProps();
        sessionFactory = new Configuration()
                .setProperties(mysqlProperties)
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
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (instance == null) {
            instance = new HibernateMySQLUtil();
        }
        return instance.sessionFactory;
    }
    private static void initialiseProps() {
        try {
            mysqlProperties = new Properties();
            mysqlProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernateMySQL.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Properties -file for Hibernate (MySQL) not found");
        }
    }

}

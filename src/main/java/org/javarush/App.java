package org.javarush;

import entity.Address;
import entity.Customer;
import services.AddressService;
import services.ClientService;
import services.FilmService;
import sessionFactory.HibernateMySQLUtil;

import java.io.IOException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        ClientService cs = new ClientService(new HibernateMySQLUtil());
        AddressService as = new AddressService(cs.getHibernateUtils());
        FilmService fs = new FilmService(cs.getHibernateUtils());
//        Address address = as.createNewAddress("London",
//                "221B, Baker st.",
//                "Piccadilly",
//                "999-999-9999");

//        Customer sherlock = cs.createCustomer(address, "Sherlock", "Holmes", "holmes@gmail.com");
//        cs.returnFilmToStore();
//        cs.customerRentInventory(sherlock);
        fs.createFilm("English");

    }
}

package org.javarush;

import entity.Store;
import services.ClientService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){


        ClientService cs = new ClientService();
        cs.createCustomer();
    }
}

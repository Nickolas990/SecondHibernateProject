package dao;

import org.hibernate.SessionFactory;

public class Inventory extends GenericDAO<Inventory>{
    public Inventory(SessionFactory sessionFactory) {
        super(Inventory.class, sessionFactory);
    }
}

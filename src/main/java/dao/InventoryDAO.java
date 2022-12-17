package dao;

import org.hibernate.SessionFactory;

public class InventoryDAO extends GenericDAO<InventoryDAO>{
    public InventoryDAO(SessionFactory sessionFactory) {
        super(InventoryDAO.class, sessionFactory);
    }
}

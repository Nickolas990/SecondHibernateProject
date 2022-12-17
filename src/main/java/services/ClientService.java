package services;

import entity.Address;
import entity.City;
import entity.Customer;
import entity.Store;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sessionFactory.HibernateMySQLUtil;
import sessionFactory.HibernateUtils;

@Getter
@Setter
public class ClientService {

    private final HibernateUtils hibernateUtils = new HibernateMySQLUtil();
    private SessionFactory sessionFactory = hibernateUtils.getSessionFactory();
    public Customer createCustomer() {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Store store = hibernateUtils
                    .getStoreDAO()
                    .getItems(0, 1)
                    .get(0);

            City city = hibernateUtils.getCityDAO().getCityByName("London");
            Address address = Address.builder()
                    .address("Baker st., 221B")
                    .phone("999-999-9999")
                    .city(city)
                    .district("London")
                    .build();
            hibernateUtils.getAddressDAO().save(address);

            Customer customer =  Customer.builder()
                    .isActive(true)
                    .email("holmes@gmail.com")
                    .address(address)
                    .store(store)
                    .firstName("Sherlock")
                    .lastName("Holmes")
                    .build();
            hibernateUtils.getCustomerDAO().save(customer);
            transaction.commit();
            return customer;
        }
    }

}

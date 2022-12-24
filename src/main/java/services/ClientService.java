package services;

import dao.CityDAO;
import entity.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sessionFactory.HibernateUtils;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class ClientService extends Service {


    public ClientService(HibernateUtils hibernateUtils) {
        super(hibernateUtils);
    }

    public Customer createCustomer(Address address, String firstName, String lastName, String email) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Store store = hibernateUtils
                    .getStoreDAO()
                    .getItems(0, 1)
                    .get(0);

            Customer customer =  Customer.builder()
                    .isActive(true)
                    .email(email)
                    .address(address)
                    .store(store)
                    .firstName(firstName)
                    .lastName(lastName)
                    .build();
            hibernateUtils.getCustomerDAO().save(customer);
            transaction.commit();
            return customer;
        }
    }

    public void returnFilmToStore() {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Rental rental = hibernateUtils.getRentalDAO().returnAnyRental();
            rental.setReturnDate(Instant.now());

            hibernateUtils.getRentalDAO().save(rental);

            transaction.commit();
        }
    }

    public void customerRentInventory(Customer customer) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Film film = hibernateUtils.getFilmDAO().findFirstFilmForRent();
            Store store = hibernateUtils
                    .getStoreDAO()
                    .getItems(0, 1)
                    .get(0);
            Staff staff = store.getManagerStaff();
            Inventory inventory = Inventory.builder()
                    .film(film)
                    .store(store)
                    .build();
            hibernateUtils.getInventoryDAO().save(inventory);

            Rental rental = Rental.builder()
                    .rentalDate(Instant.now())
                    .customer(customer)
                    .inventory(inventory)
                    .staff(staff)
                    .build();

            hibernateUtils.getRentalDAO().save(rental);

            Payment payment = Payment.builder()
                    .rental(rental)
                    .paymentDate(Instant.now())
                    .customer(customer)
                    .amount(BigDecimal.valueOf(55.55))
                    .staff(staff)
                    .build();
            hibernateUtils.getPaymentDAO().save(payment);
            transaction.commit();
        }
    }

}

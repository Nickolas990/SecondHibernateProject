package services;

import entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sessionFactory.HibernateUtils;

public class AddressService extends Service{


    public AddressService(HibernateUtils hibernateUtils) {
        super(hibernateUtils);
    }

    public Address createNewAddress(String cityName, String streetAndBuilding, String district, String phone) {

        Address address = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            address = Address.builder()
                    .city(hibernateUtils.getCityDAO().getCityByName(cityName))
                    .address(streetAndBuilding)
                    .district(district)
                    .phone(phone)
                    .build();
            hibernateUtils.getAddressDAO().save(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return address;
    }

}

package sessionFactory;

import dao.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.SessionFactory;

import java.util.Properties;

@Getter
@Setter
public abstract class HibernateUtils {
    protected static Properties properties;

    protected SessionFactory sessionFactory;


    protected ActorDAO actorDAO;
    protected AddressDAO addressDAO;
    protected CategoryDAO categoryDAO;
    protected CityDAO cityDAO;
    protected CountryDAO countryDAO;
    protected CustomerDAO customerDAO;
    protected FilmDAO filmDAO;
    protected FilmTextDAO filmTextDAO;
    protected InventoryDAO inventoryDAO;
    protected LanguageDAO languageDAO;
    protected PaymentDAO paymentDAO;
    protected RentalDAO rentalDAO;
    protected StaffDAO staffDAO;
    protected StoreDAO storeDAO;

    public abstract SessionFactory getSessionFactory();

}

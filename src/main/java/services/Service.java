package services;

import lombok.Getter;
import org.hibernate.SessionFactory;
import sessionFactory.HibernateUtils;
@Getter
public abstract class Service {
    protected HibernateUtils hibernateUtils;
    protected SessionFactory sessionFactory;

    public Service(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
        sessionFactory = hibernateUtils.getSessionFactory();
    }

}

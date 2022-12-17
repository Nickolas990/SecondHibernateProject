package dao;

import org.hibernate.SessionFactory;

public class FilmTextDAO extends GenericDAO<FilmTextDAO>{
    public FilmTextDAO(SessionFactory sessionFactory) {
        super(FilmTextDAO.class, sessionFactory);
    }
}

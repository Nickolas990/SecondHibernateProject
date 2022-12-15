package dao;

import org.hibernate.SessionFactory;

public class FilmText extends GenericDAO<FilmText>{
    public FilmText(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}

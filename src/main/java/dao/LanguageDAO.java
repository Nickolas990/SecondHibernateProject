package dao;

import entity.Language;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

public class LanguageDAO extends GenericDAO<Language>{
    public LanguageDAO(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }

    public Language getLanguageByName(String lang) {
        Query<Language> query = getCurrentSession().createQuery("select l from Language l where l.name = :name", Language.class);
        query.setParameter("name", lang);
        return query.getSingleResult();
    }
}

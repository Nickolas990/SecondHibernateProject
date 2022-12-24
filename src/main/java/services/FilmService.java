package services;

import entity.Actor;
import entity.Category;
import entity.Film;
import entity.Language;
import entity.enums.Feature;
import entity.enums.Rating;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sessionFactory.HibernateUtils;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilmService extends Service {
    public FilmService(HibernateUtils hibernateUtils) {
        super(hibernateUtils);
    }
    public Film createFilm(String lang) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Language language = hibernateUtils.getLanguageDAO().getLanguageByName(lang);
            Set<Actor> actors = new HashSet<>(hibernateUtils.getActorDAO().getItems(0, 20));
            Set<Category> categories = new HashSet<>(hibernateUtils.getCategoryDAO().getItems(0, 5));


            Film film = Film.builder()
                    .actors(actors)
                    .language(language)
                    .categories(categories)
                    .rating(Rating.NC17)
                    .length((short) 90)
                    .releaseYear(Year.now())
                    .rentalDuration((byte) 30)
                    .replacementCost(BigDecimal.TEN)
                    .rentalRate(BigDecimal.valueOf(5))
                    .title("The Call Of Java")
                    .description("The long story about the programmer and his journey to Java Island. " +
                            "On the island he needs to find a mystery \"First JAVA tutorial\"")
                    .build();

            film.setSpecialFeatures(Set.of(Feature.BEHIND_THE_SCENES, Feature.DELETED_SCENES));
            hibernateUtils.getFilmDAO().save(film);
            transaction.commit();


            return film;
        }



    }
}

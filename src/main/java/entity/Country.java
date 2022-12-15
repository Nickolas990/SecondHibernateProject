package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "country", schema = "movie")
@Getter
@Setter
public class Country {
    @Id
    @Column(name = "country_id", columnDefinition = "SMALLINT UNSIGNED not null")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "country", nullable = false, length = 50)
    private String title;

    @Column(name = "last_update", nullable = false)
    @UpdateTimestamp
    private Instant lastUpdate;

}
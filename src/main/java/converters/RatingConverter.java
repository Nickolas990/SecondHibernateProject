package converters;

import entity.enums.Rating;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {
    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return rating.getValue();
    }

    @Override
    public Rating convertToEntityAttribute(String dbData) {
        Rating[] ratings = Rating.values();
        for (Rating rating : ratings) {
            if (Objects.nonNull(rating) && rating.getValue().equals(dbData)) {
                return rating;
            }
        }
        return null;
    }
}

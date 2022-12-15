package DTO;

import entity.Address;
import entity.Payment;
import entity.Rental;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link entity.Customer} entity
 */
@Data
public class CustomerDto implements Serializable {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Address address;
    private final Set<Payment> payments;
    private final Set<Rental> rentals;
}
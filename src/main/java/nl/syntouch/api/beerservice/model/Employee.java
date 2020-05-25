package nl.syntouch.api.beerservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String firstname;

    private String middlename;

    @NotNull
    private String lastname;

    private int points;
}

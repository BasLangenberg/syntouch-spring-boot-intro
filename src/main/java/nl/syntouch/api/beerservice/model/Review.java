package nl.syntouch.api.beerservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private UUID userId;

    @NotNull
    @Size(min = 0, max = 5)
    private Integer stars;

    private String description;
}

package nl.syntouch.api.beerservice.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Entity
public class Beer {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer quantity;

    @NotNull
    private OffsetDateTime brewDate;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "BEER_ID")
    List<Review> reviews;

}

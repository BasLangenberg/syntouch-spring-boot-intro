package nl.syntouch.api.beerservice.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

    private int price;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "BEER_ID")
    List<Review> reviews;

}

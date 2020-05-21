package nl.syntouch.api.beerservice.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class BeerDto {
    @NotNull
    private String name;

    @NotNull
    private Integer quantity;

    @NotNull
    private OffsetDateTime brewDate;

    List<ReviewDto> reviews;
}

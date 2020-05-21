package nl.syntouch.api.beerservice.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class ReviewDto {

    @NotNull
    private UUID userId;

    @NotNull
    @Size(min = 0, max = 5)
    private Integer stars;

    private String description;
}

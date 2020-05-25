package nl.syntouch.api.beerservice.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EmployeeDto {
    @NotNull
    private String firstname;

    private String middlename;

    @NotNull
    private String lastname;

    private int points;
}

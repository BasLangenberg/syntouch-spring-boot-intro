package nl.syntouch.api.beerservice.dto;

import lombok.Data;
import lombok.Generated;
import nl.syntouch.api.beerservice.model.OrderItem;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class OrderDto {
    @NotNull
    private Long EmployeeId;

    @Generated
    @NotNull
    private Long id;

    private List<OrderItem> orderItems;
}

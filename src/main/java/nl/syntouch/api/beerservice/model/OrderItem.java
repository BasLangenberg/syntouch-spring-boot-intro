package nl.syntouch.api.beerservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;



    private Integer quantity;
}

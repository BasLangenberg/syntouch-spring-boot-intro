package nl.syntouch.api.beerservice.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "beer_order")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private OffsetDateTime orderDate;

    private Long employeeId;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ORDER_ID")
    private List<OrderItem> orderItems;
}

package nl.syntouch.api.beerservice.service;

import nl.syntouch.api.beerservice.model.Order;
import nl.syntouch.api.beerservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {

    private final EmployeeService employeeService;
    private final BeerService beerService;
    private final OrderRepository orderRepository;

    public OrderService(EmployeeService employeeService, BeerService beerService, OrderRepository orderRepository) {
        this.employeeService = employeeService;
        this.beerService = beerService;
        this.orderRepository = orderRepository;
    }

    public void placeOrder(Order order) {
        //Bestaat de Employee? Heeft hij genoeg punten?

        // Is er genoeg Beer.getQuantity?

        // update de beer quantity

        // save de order

    }
}

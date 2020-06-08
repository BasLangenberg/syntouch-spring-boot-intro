package nl.syntouch.api.beerservice.service;

import nl.syntouch.api.beerservice.model.Beer;
import nl.syntouch.api.beerservice.model.Employee;
import nl.syntouch.api.beerservice.model.Order;
import nl.syntouch.api.beerservice.model.OrderItem;
import nl.syntouch.api.beerservice.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        List<Employee> emp = employeeService.getEmployee();
        boolean found = false;
        for (int i = 0; i<emp.size(); i++) {
            if (emp.get(i).getId() == order.getEmployeeId()){
                found = true;
                break;
            }
        }

        // Error handling to be improved
        if (!found) {
            throw new RuntimeException("Employee not found");
        }


        // Is er genoeg voorraad, en heeft de employee genoeg punten?
        boolean enoughStock = true;
        List<OrderItem> orderItems = order.getOrderItems();
        for (OrderItem ord : orderItems){
            // TIL java.Optional
            Beer beer = beerService.getBeerById(ord.beerId).orElseThrow(RuntimeException::new);

            if(beer.getQuantity() < ord.getQuantity()){
                enoughStock = false;
            }
        }



        // Error handling to be improved
        if (!enoughStock) {
            throw new RuntimeException("Insufficient beer");
        }

        // Heeft de employee genoeg punten?
        int requiredPoints = 0;
        for(OrderItem ord : orderItems){
            requiredPoints += beerService.getBeerById(ord.beerId).get().getPrice();
        };


        // update all values
        for (int i = 0; i<emp.size(); i++) {
            if (emp.get(i).getId() == order.getEmployeeId()){
                emp.get(i).setPoints(emp.get(i).getPoints() - requiredPoints);
                employeeService.saveEmployee(emp.get(i));
                break;
            }
        }

        for(OrderItem ord : orderItems){

            // TIL java.Optional
            Beer beer = beerService.getBeerById(ord.beerId).orElseThrow(RuntimeException::new);

            beer.setQuantity(beer.getQuantity() - ord.getQuantity());
            beerService.saveBeer(beer);

        }

        // save de order
        orderRepository.save(order);

    }

    public List<Order> getOrder() {
        return orderRepository.findAll();
    }
}

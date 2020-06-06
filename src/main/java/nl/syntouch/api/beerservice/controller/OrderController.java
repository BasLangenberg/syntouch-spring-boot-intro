package nl.syntouch.api.beerservice.controller;

import nl.syntouch.api.beerservice.dto.OrderDto;
import nl.syntouch.api.beerservice.model.Order;
import nl.syntouch.api.beerservice.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<OrderDto> getOrder() {
        return modelMapper.map(orderService.getOrder(), new TypeToken<List<OrderDto>>(){
        }.getType());
    }

    @PostMapping
    public void postOrder(@Valid @RequestBody OrderDto orderDto) {
        orderService.placeOrder(modelMapper.map(orderDto, Order.class));
    }
}

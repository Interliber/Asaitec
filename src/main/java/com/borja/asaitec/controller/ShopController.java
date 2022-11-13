package com.borja.asaitec.controller;

import com.borja.asaitec.dto.OrderDto;
import com.borja.asaitec.dto.ResponseDto;
import com.borja.asaitec.model.Customer;
import com.borja.asaitec.model.Item;
import com.borja.asaitec.model.Order;
import com.borja.asaitec.services.CustomerService;
import com.borja.asaitec.services.ItemService;
import com.borja.asaitec.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/shopController")
public class ShopController {

    private OrderService orderService;
    private ItemService itemService;
    private CustomerService customerService;


    public ShopController(OrderService orderService, ItemService itemService, CustomerService customerService) {
        this.orderService = orderService;
        this.itemService = itemService;
        this.customerService = customerService;
    }

    private Logger logger = LoggerFactory.getLogger(ShopController.class);

    @GetMapping(value = "/getAllItems")
    public ResponseEntity<List<Item>> getAllItems() {

        List<Item> itemList = itemService.getAllItems();

        return ResponseEntity.ok(itemList);
    }

    @GetMapping(value = "/getOrder/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable int orderId) {

        Order order = orderService.getDetail(orderId);
        return ResponseEntity.ok(order);
    }


    @PostMapping("/placeOrder")
    public ResponseEntity<ResponseDto> placeOrder(@RequestBody OrderDto orderDto) {
        logger.info("Request Payload " + orderDto.toString());
        ResponseDto responseDto = new ResponseDto();
        double amount = orderService.getTotal(orderDto.getCartItems());

        Customer customer = new Customer(orderDto.getCustomerName(), orderDto.getCustomerEmail());
        Integer customerIdFromDb = customerService.customerExists(customer);
        if (customerIdFromDb != null) {
            customer.setId(customerIdFromDb);
            logger.info("Customer already present in db with id : " + customerIdFromDb);
        }else{
            customer = customerService.save(customer);
            logger.info("Customer saved.. with id : " + customer.getId());
        }
        Order order = new Order(orderDto.getOrderDescription(), customer, orderDto.getCartItems());
        order = orderService.save(order);
        logger.info("Order processed successfully..");

        responseDto.setAmount(amount);
        responseDto.setInvoiceNumber(new Random().nextInt(1000));
        responseDto.setOrderId(order.getId());
        responseDto.setOrderDescription(orderDto.getOrderDescription());

        logger.info("test push..");

        return ResponseEntity.ok(responseDto);
    }

}

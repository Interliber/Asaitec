package com.borja.asaitec.services;

import com.borja.asaitec.model.Item;
import com.borja.asaitec.model.Order;
import com.borja.asaitec.model.ShoppingCart;
import com.borja.asaitec.repository.ItemRepository;
import com.borja.asaitec.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository){
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    public Order getDetail(int orderId){
        Optional<Order> order = this.orderRepository.findById(orderId);
        return order.isPresent() ? order.get() : null;
    }

    public double getTotal(List<ShoppingCart> shoppingList){
        double total = 0;
        double item = 0;
        int avalaible = 0;

        for (ShoppingCart cart : shoppingList) {

            int itemId = cart.getProductId();
            Optional<Item> product = itemRepository.findById(itemId);
            if (product.isPresent()) {
                Item product1 = product.get();
                if (product1.getAvalaible() < cart.getQuantity()) {
                    item = product1.getPrice() * product1.getAvalaible();
                    cart.setQuantity(product1.getAvalaible());
                } else {
                    item = cart.getQuantity() * product1.getPrice();
                    avalaible = product1.getAvalaible() - cart.getQuantity();
                }
                total = total + item;
                product1.setAvalaible(avalaible);
                avalaible=0;
                cart.setProductName(product1.getName());
                cart.setAmount(item);
                itemRepository.save(product1);
            }
        }
        return total;
    }
    public Order save (Order order) {
        return orderRepository.save(order);
    }
}

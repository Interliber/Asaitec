package com.borja.asaitec.dto;

import com.borja.asaitec.model.ShoppingCart;

import java.util.List;

public class OrderDto {

    private String orderDescription;
    private List<ShoppingCart> cartItems;
    private String customerEmail;
    private String customerName;

    public OrderDto() {
    }

    public OrderDto(String orderDescription, List<ShoppingCart> cartItems, String customerEmail, String customerName) {
        this.orderDescription = orderDescription;
        this.cartItems = cartItems;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public List<ShoppingCart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCart> cartItems) {
        this.cartItems = cartItems;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderDescription='" + orderDescription + '\'' +
                ", cartItems=" + cartItems +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
package com.borja.asaitec.repository;

import com.borja.asaitec.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}

package com.borja.asaitec.repository;

import com.borja.asaitec.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {
}

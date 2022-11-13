package com.borja.asaitec.repository;

import com.borja.asaitec.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}

package com.borja.asaitec.services;

import com.borja.asaitec.model.Item;
import com.borja.asaitec.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository repo;

    public ItemService(ItemRepository repo){
        this.repo = repo;
    }
    public List<Item> getAllItems(){
        return this.repo.findAll();
    }
}

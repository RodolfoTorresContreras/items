package com.formaciondbi.springboot.app.item.models.service;

import com.formaciondbi.springboot.app.item.clientes.ProductoClienteRest;
import com.formaciondbi.springboot.app.item.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
public class ItemServiceFeignImpl implements ItemService {

    @Autowired
    private ProductoClienteRest productoClienteRest;
    @Override
    public List<Item> findAll() {
        return productoClienteRest.findAll().stream().map(producto -> new Item(producto,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(productoClienteRest.findById(id),cantidad);
    }
}

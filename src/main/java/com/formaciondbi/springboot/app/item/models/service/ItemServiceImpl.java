package com.formaciondbi.springboot.app.item.models.service;

import com.formaciondbi.springboot.app.item.models.Item;
import com.formaciondbi.springboot.app.item.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("serviceRest")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clientRestTemplate;
    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(clientRestTemplate.getForObject("http://productos/producto",Producto[].class));
        return productos.stream().map(producto -> new Item(producto,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String,String> pathVariables = new HashMap<>();
        pathVariables.put("id",id.toString());
        Producto producto = clientRestTemplate.getForObject("http://productos/producto/{id}",Producto.class,pathVariables);
        return new Item(producto,cantidad);
    }
}

package com.formaciondbi.springboot.app.item.clientes;

import com.formaciondbi.springboot.app.item.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "productos",url="localhost:8001")
public interface ProductoClienteRest {

    @GetMapping("/producto")
    public List<Producto> findAll();
    @GetMapping("/producto/{id}")
    public Producto findById(@PathVariable Long id);
}

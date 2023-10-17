package com.formaciondbi.springboot.app.item.clientes;

import com.formaciondbi.springboot.app.item.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "productos")
public interface ProductoClienteRest {

    @GetMapping("/producto")
    public List<Producto> findAll();
    @GetMapping("/producto/{id}")
    public Producto findById(@PathVariable Long id);
}

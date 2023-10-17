package com.formaciondbi.springboot.app.item.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable {

    private Producto producto;

    private Integer cantidad;

    public Item(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Item() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal(){
        return producto.getPrecio().multiply(new BigDecimal(cantidad));
    }
}

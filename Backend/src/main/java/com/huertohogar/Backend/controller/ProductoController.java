package com.huertohogar.Backend.controller;

import com.huertohogar.Backend.model.Producto;
import com.huertohogar.Backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Producto> getProductosByCategoria(@PathVariable String categoria) {
        return productoService.getProductosByCategoria(categoria);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto existingProducto = productoService.getProductoById(id);
        if (existingProducto != null) {
            existingProducto.setCodigo(producto.getCodigo());
            existingProducto.setNombre(producto.getNombre());
            existingProducto.setPrecio(producto.getPrecio());
            existingProducto.setImg(producto.getImg());
            existingProducto.setCategoria(producto.getCategoria());
            existingProducto.setPrecioKilo(producto.getPrecioKilo());
            existingProducto.setDescripcion(producto.getDescripcion());
            return productoService.saveProducto(existingProducto);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }
}
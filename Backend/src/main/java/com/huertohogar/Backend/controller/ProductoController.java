package com.huertohogar.Backend.controller;

import com.huertohogar.Backend.model.Producto;
import com.huertohogar.Backend.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "Operaciones para gestionar el catálogo de productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Devuelve el listado completo de productos disponibles.")
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID", description = "Busca un producto específico por su identificador único.")
    public Producto getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @GetMapping("/categoria/{categoria}")
    @Operation(summary = "Filtrar por categoría", description = "Devuelve productos filtrados (ej: frutas, verduras).")
    public List<Producto> getProductosByCategoria(@PathVariable String categoria) {
        return productoService.getProductosByCategoria(categoria);
    }

    @PostMapping
    @Operation(summary = "Crear nuevo producto", description = "(Requiere rol ADMIN)", security = @SecurityRequirement(name = "bearerAuth"))
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto", description = "(Requiere rol ADMIN)", security = @SecurityRequirement(name = "bearerAuth"))
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
    @Operation(summary = "Eliminar producto", description = "Borra un producto de la base de datos permanentemente (Requiere rol ADMIN).", security = @SecurityRequirement(name = "bearerAuth"))
    public void deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }
}
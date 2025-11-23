package com.huertohogar.Backend.config;

import com.huertohogar.Backend.model.Producto;
import com.huertohogar.Backend.model.Usuario;
import com.huertohogar.Backend.repository.ProductoRepository;
import com.huertohogar.Backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public DatabaseLoader(ProductoRepository productoRepository, UsuarioRepository usuarioRepository) {
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        productoRepository.deleteAll();
        usuarioRepository.deleteAll();

        usuarioRepository.save(new Usuario("admin@huerto.cl", "admin123", "ADMIN"));


        usuarioRepository.save(new Usuario("cliente@huerto.cl", "cliente123", "USER"));

        // --- FRUTAS ---
        productoRepository.save(new Producto(
                "FR001", "Manzana Fuji", 937,
                "https://media.istockphoto.com/id/184276818/es/foto/manzana-red.jpg?s=612x612&w=0&k=20&c=BFD8ixD7eyXMm3aSVIdz1hUsLG-lX8Ig2HBr6IVJuzU=",
                "frutas", "$2.490 x kg", "Granel"));

        productoRepository.save(new Producto(
                "FR002", "Naranjas Valencianas", 549,
                "https://media.istockphoto.com/id/185284489/es/foto/naranja.jpg?s=612x612&w=0&k=20&c=V_kmzGGofV9oTdQMU-SfT4Y9n3q9ksFZliED5O_eYPE=",
                "frutas", "$1.290 x kg", "Granel"));

        productoRepository.save(new Producto(
                "FR003", "Plátanos Cavendish", 747,
                "https://media.istockphoto.com/id/173242750/es/foto/racimo-de-pl%C3%A1tanos.jpg?s=612x612&w=0&k=20&c=-RqILbvnZIp5YZRm3BGc-i5n_e2VsJCUu9GU9OqVAbk=",
                "frutas", "$1.490 x kg", "Granel"));

        // --- VERDURAS ---
        productoRepository.save(new Producto(
                "VR001", "Zanahorias Hubolt", 937,
                "https://media.istockphoto.com/id/166106089/es/foto/aislado-de-zanahoria.jpg?s=612x612&w=0&k=20&c=4PYVf5-dUR1N5ZLjDBVBaATdUq3KjNS6tjFHiyaW6Xk=",
                "verduras", "$2.490 x kg", "Granel"));

        productoRepository.save(new Producto(
                "VR002", "Espinacas Frescas", 549,
                "https://juanesparraguito.com/cdn/shop/files/FotosWeb_parte2_Mesadetrabajo1copia50.jpg?v=1711034505&width=1214",
                "verduras", "$1.290 x kg", "Granel"));

        productoRepository.save(new Producto(
                "VR003", "Pimientos Tricolores", 747,
                "https://www.ammarket.com/wp-content/uploads/2021/11/pimiento_tricolor_ammarket_frutas_verduras_a_domicilio_2.jpg",
                "verduras", "$1.490 x kg", "Granel"));

        // --- ORGANICOS ---
        productoRepository.save(new Producto(
                "PO001", "Miel Orgánica", 949,
                "https://www.ecopraha.cl/wp-content/uploads/2022/imagenes/POTE_MIEL_1KG.PNG",
                "organicos", "$2.490 x 2", "Granel"));

        productoRepository.save(new Producto(
                "PO002", "Quinoa Avellana", 620,
                "https://acdn-us.mitiendanube.com/stores/002/625/145/products/granola-exotica-2023-04-03t152012-8511-89ac452da81f95c3b816805464075205-640-0.jpg",
                "organicos", "$1.490 x kg", "Granel"));

        // --- LACTEOS ---
        productoRepository.save(new Producto(
                "PL001", "Leche Semidescremada Surlat", 1190,
                "https://i.bolder.run/r/czoyMzA1MyxnOjEwMDB4/0ab17529/856531-LECHE-SURLAT-SEMI-DESCREMADA-1LT.jpg",
                "lacteos", null, "1 litro x unidad"));

        System.out.println("Base de datos inicializada con Productos y Usuarios...");
    }
}
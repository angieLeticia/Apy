package com.apy.make.domain.repository;

import com.apy.make.domain.Product;

import java.util.List;
import java.util.Optional;
// nombre de los metodos que queremos que cualquier repositorio que valla a trabaja con repositorios tenga que implementar
public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}

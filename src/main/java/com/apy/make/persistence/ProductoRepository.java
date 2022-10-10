package com.apy.make.persistence;

import com.apy.make.domain.Product;
import com.apy.make.domain.repository.ProductRepository;
import com.apy.make.persistence.crud.ProductoCrudRepository;
import com.apy.make.persistence.entity.Producto;
import com.apy.make.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
// con esta anotacion le estamos diciendo a sprin que esta clase que esta clase se encaraga de interactuar con la base de datos.
@Repository
public class ProductoRepository  implements ProductRepository {
    private ProductoCrudRepository productoCrudRepository;
    // realiza la convercion de Producto a product
    private ProductMapper mapper;

    // este  metodo sirve para optener toda la lista de   producto de la tabla
    @Override
    public List<Product> getAll(){
        List<Producto> productos =(List<Producto>) productoCrudRepository.findAll();
        return mapper.toProduct(productos);

    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    public List<Producto> getByCategoria(int idCategoria){
        return  productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }
    // ESTE METODO ME MUESTRA LA LISTA DE PRODUTOS ESCASOS
    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    // ESTE METODO ME PUEDE TRAER UN PRODUCTO DANDO SU ID
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public  Producto save(Producto producto) {
        return  productoCrudRepository.save(producto);
    }
     public  void delete (int idProducto){
        productoCrudRepository.deleteById(idProducto);
     }
}

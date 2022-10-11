package com.apy.make.persistence;

import com.apy.make.domain.Product;
import com.apy.make.domain.repository.ProductRepository;
import com.apy.make.persistence.crud.ProductoCrudRepository;
import com.apy.make.persistence.entity.Producto;
import com.apy.make.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
// con esta anotacion le estamos diciendo a sprin que esta clase que esta clase se encaraga de interactuar con la base de datos.
@Repository
public class ProductoRepository  implements ProductRepository {
    @Autowired
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
        List<Producto> productos =productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProduct(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        // ya que no existe una mapiador que mapeer lista de opcinales  se crea a los producto un mapper
        return productos.map(prods -> mapper.toProduct(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {

        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }


    // ESTE METODO ME MUESTRA LA LISTA DE PRODUTOS ESCASOS
    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    // ESTE METODO ME PUEDE TRAER UN PRODUCTO DANDO SU ID

    public  Producto save(Producto producto) {
        return  productoCrudRepository.save(producto);
    }
     public  void delete (int productId){
        productoCrudRepository.deleteById(productId);
     }
}

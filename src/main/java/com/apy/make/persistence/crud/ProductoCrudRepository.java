package com.apy.make.persistence.crud;

import com.apy.make.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// EST ES UNA INTERFAZ, EN ESTA INTERFAZ VAMOS A MANEJAR LOS DATOS DE PRODUCTO POR ESTA RAZON SE extends a CrudRepository los datos que solicitamos es <> es el nombre de
// la tabla y el tipo de dato de id de la tabla
public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {
  // este metodo es Query Methods se crea de la sigueinte manera
 //retorna una lista de producto, segun la nomenclaruta de los Query Methods se debe empezar por findBy (en este caso) enseguida del nombre del metodo
 //segun camen IdCategoria (en este caso) se abren parametros y se llama el tipo de dato y la tabla que se desea traer)

 List<Producto>findByIdCategoriaOrderByNombreAsc(int idCategoria);
 Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}

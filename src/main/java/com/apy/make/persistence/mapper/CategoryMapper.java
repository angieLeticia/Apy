package com.apy.make.persistence.mapper;

import com.apy.make.domain.Category;
import com.apy.make.persistence.entity.Categoria;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
// esta manera se convierten categorias en caterory
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    }
    )
    Category toCategoty(Categoria categoria);

    // esa anotacion le dice a nuestro map que la convercion es inversa
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}

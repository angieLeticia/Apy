package com.apy.make.persistence.mapper;

import com.apy.make.domain.PurchaseItem;
import com.apy.make.persistence.entity.ComprasProducto;
import com.apy.make.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

        @Mappings({
                @Mapping(source = "id.idProducto", target = "productId"),
                @Mapping(source = "cantidad", target = "quantity"),
                @Mapping(source = "estado", target = "active")
        })
       PurchaseItem toPurcheseItem(ComprasProducto producto);
        @InheritInverseConfiguration
        @Mappings({
                @Mapping(target = "compra", ignore = true),
                @Mapping(target = "producto", ignore = true),
                @Mapping(target = "id.idCompra", ignore = true),
        })
        ComprasProducto toComprasProducto(PurchaseItem item);
}


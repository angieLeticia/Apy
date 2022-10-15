package com.apy.make.persistence;

import com.apy.make.domain.Purchase;
import com.apy.make.domain.repository.PurcheseRepository;
import com.apy.make.persistence.crud.CompraCrudRepository;
import com.apy.make.persistence.entity.Compra;
import com.apy.make.persistence.mapper.PuchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CompraRepository implements PurcheseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PuchaseMapper mapper;

    @Override
    public List<Purchase> getAll(){
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByCliente(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId).map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Optional<List<Purchase>> getByCliente(Integer clientId) {
        return Optional.empty();
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);

        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}

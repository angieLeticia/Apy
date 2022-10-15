package com.apy.make.domain.repository;

import com.apy.make.domain.Purchase;

import java.util.List;
import java.util.Optional;
import java.util.SplittableRandom;

public interface PurcheseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByCliente(String clientId);

    Optional<List<Purchase>> getByCliente(Integer clientId);

    Purchase save(Purchase purchase);
}

package com.apy.make.domain.service;

import com.apy.make.domain.Purchase;
import com.apy.make.domain.repository.PurcheseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurcheseRepository purcheseRepository;

    public List<Purchase> getAll(){
        return purcheseRepository.getAll();
    }
    public Optional<List<Purchase>> getByCliente(String clientId){
        return purcheseRepository.getByCliente(clientId);
    }

    public Purchase save(Purchase purchase){
        return purcheseRepository.save(purchase);
    }


}

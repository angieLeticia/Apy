package com.apy.make.domain.service;

import com.apy.make.domain.Purchase;
import com.apy.make.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purcheseRepository;

    public List<Purchase> getAll(){
        return purcheseRepository.getAll();
    }
    public Optional<List<Purchase>> getByClient(String clientId){
        return purcheseRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase){
        return purcheseRepository.save(purchase);
    }


}

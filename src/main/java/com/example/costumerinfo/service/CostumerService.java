package com.example.costumerinfo.service;

import com.example.costumerinfo.entity.Costumer;
import com.example.costumerinfo.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepository repository;

    public Costumer saveCostumer(Costumer costumer){
        return repository.save(costumer);
    }
    public List<Costumer> getCostumers(){
        return repository.findAll();
    }
    public Costumer getCostumerById(int id){
        return repository.findById(id).orElse(null);
    }
    public Costumer updateCostumer(Costumer costumer){
        Costumer  existingCostumer= repository.findById(costumer.getId()).orElse(null);
        existingCostumer.setName(costumer.getName());
        existingCostumer.setPhoneNumber(costumer.getPhoneNumber());
        existingCostumer.setAddress(costumer.getAddress());
        return repository.save(existingCostumer);
    }
    public String deleteCostumer(int id){
        repository.deleteById(id);
        return "Costumer " + id + " was removed";
    }
}

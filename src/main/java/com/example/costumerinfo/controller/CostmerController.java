package com.example.costumerinfo.controller;

import com.example.costumerinfo.entity.Costumer;
import com.example.costumerinfo.exception.ResourceNotFoundException;
import com.example.costumerinfo.repository.CostumerRepository;
import com.example.costumerinfo.service.CostumerService;
//import com.example.costumerinfo.service.TwilioService;
import com.example.costumerinfo.service.TwilioService;
import com.twilio.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping()
@RestController
public class CostmerController {
    @Autowired
    private CostumerRepository costumerRepository;
    private TwilioService service;

    @GetMapping("/costumers")
    public List<Costumer> getAllCostumers(){
        return costumerRepository.findAll();
    }
    @PostMapping("/costumers")
    public Costumer createCostumer(@RequestBody Costumer costumer){
        return costumerRepository.save(costumer);
    }

    @PutMapping("/costumers/{id}")
    public ResponseEntity<Costumer> updateCostumer(@PathVariable int id, @RequestBody Costumer costumerDetails){
        Costumer costumer = costumerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Costumer not exist with id :"+ id));

        if(!costumerDetails.getName().isEmpty()){
            costumer.setName(costumerDetails.getName());
        }
//
        if(!costumerDetails.getPhoneNumber().isEmpty()) {
            costumer.setPhoneNumber(costumerDetails.getPhoneNumber());
        }
        if(!costumerDetails.getAddress().isEmpty()) {
            costumer.setAddress(costumerDetails.getAddress());
        }

        Costumer updatedCostumer = costumerRepository.save(costumer);
        return ResponseEntity.ok(updatedCostumer);
    }
    @DeleteMapping("/costumers/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteCostumer(@PathVariable int id){
        Costumer costumer = costumerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Costumer not exist with id :"+ id));
        costumerRepository.delete(costumer);
        Map<String,Boolean> response = new HashMap<>();

        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

package com.example.costumerinfo.controller;

import com.example.costumerinfo.entity.Costumer;
import com.example.costumerinfo.exception.ResourceNotFoundException;

import com.example.costumerinfo.service.CostumerService;
import com.example.costumerinfo.service.GooglePhoneLib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping()
@RestController
public class CostmerController {
    @Autowired
    private CostumerService costumerService;

    private GooglePhoneLib phoneLib;

    @GetMapping("/costumers")
    public List<Costumer> getAllCostumers(){
        return costumerService.getCostumers();
    }

    @PostMapping("/costumers")
    public ResponseEntity<Costumer> createCostumer(@RequestBody Costumer costumer){
        boolean check=phoneLib.isPhoneNumberValid(costumer.getPhoneNumber());
        if(check){
            Costumer savedCostumer= costumerService.saveCostumer(costumer);
            return ResponseEntity.ok(savedCostumer);
        }
        return new ResponseEntity<Costumer>(HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/costumers/{id}")
    public ResponseEntity<Costumer> updateCostumer(@PathVariable int id, @RequestBody Costumer costumerDetails){
        Costumer costumer = costumerService.getCostumerById(id);

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
        boolean check=phoneLib.isPhoneNumberValid(costumer.getPhoneNumber());
        if(check){
            Costumer updatedCostumer = costumerService.saveCostumer(costumer);
            return ResponseEntity.ok(updatedCostumer);
        }
        return new ResponseEntity<Costumer>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/costumers/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteCostumer(@PathVariable int id){

        costumerService.deleteCostumer(id);
        Map<String,Boolean> response = new HashMap<>();

        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

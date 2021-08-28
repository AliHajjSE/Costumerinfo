package com.example.costumerinfo.controller;

import com.example.costumerinfo.entity.Costumer;
import com.example.costumerinfo.service.CostumerService;
import com.example.costumerinfo.service.TwilioService;
import com.twilio.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CostmerController {
    @Autowired
    private CostumerService service;
    private TwilioService twilioService;

    @PostMapping("/costumers")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public Costumer addCostumer(@RequestBody Costumer costumer){

        try {
            String phoneNumber= Integer.toString(costumer.getPhoneNumber());
             phoneNumber = phoneNumber.replaceAll("[\\s()-]", "");
            System.out.println(phoneNumber);
            if ("".equals(phoneNumber)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Content can't be empty");
            }
            twilioService.validate(phoneNumber);


        } catch (ApiException e){
            System.out.println(e);
            if (e.getStatusCode() == 400){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid phone number");
            }

        }
        return service.saveCostumer(costumer);
    }
    @GetMapping("/costumers")
    public List<Costumer> findAllCostumers(){
        return service.getCostumers();
    }
    @GetMapping("/costumerById/{id}")
    public Costumer findCostumerById(@PathVariable("id") int id){
        return service.getCostumerById(id);
    }

    @PutMapping("/updateCostumer")
    public Costumer updateCostumer(@RequestBody Costumer costumer){
        return service.updateCostumer(costumer);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCostumer(@PathVariable("id")int id){
        return service.deleteCostumer(id);
    }
}

package com.example.costumerinfo.repository;

import com.example.costumerinfo.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer,Integer> {
}

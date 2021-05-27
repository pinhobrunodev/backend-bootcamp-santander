package com.project.bootcamp.repository;

import com.project.bootcamp.model.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository // Indica que vai ser um repository, ajuda a controlar as instancias 
public interface StockRepository extends JpaRepository<Stock,Long> {
    
}

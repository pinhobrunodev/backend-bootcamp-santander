package com.project.bootcamp.repository;

import java.time.LocalDate;
import java.util.Optional;

import com.project.bootcamp.model.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository // Indica que vai ser um repository, ajuda a controlar as instancias 
public interface StockRepository extends JpaRepository<Stock,Long> {
    
    // Verificando se ja existe na base de dados uma magazine luiza cadastrada pra hoje
    Optional<Stock> findByNameAndDate(String name, LocalDate date);
    
}

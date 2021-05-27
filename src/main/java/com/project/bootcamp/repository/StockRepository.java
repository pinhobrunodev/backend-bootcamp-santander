package com.project.bootcamp.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.project.bootcamp.model.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository // Indica que vai ser um repository, ajuda a controlar as instancias
public interface StockRepository extends JpaRepository<Stock, Long> {

    // Verificando se ja existe na base de dados uma magazine luiza cadastrada pra
    // hoje
    Optional<Stock> findByNameAndDate(String name, LocalDate date);

    // Vou anotar a query
    @Query("SELECT stock  FROM Stock stock WHERE stock.name = :name AND stock.date = :date AND stock.id <> :id")
    // :name,:id,:date = > Valores passados no parametro || stock.id <> :id => que nao seja eu
    Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id);

    // Retornando o stock do dia de hoje
    @Query("SELECT stock  FROM Stock stock WHERE stock.date = :date ")
    // Vamos passar no parametro um date para nao ficarmos dependentes do banco de dados
    // Esse date sera informado como parametro no service , fazendo com que o usuario nao precise informar nd
    Optional<List<Stock>> findByToday(LocalDate date);

}

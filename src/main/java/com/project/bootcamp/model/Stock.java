package com.project.bootcamp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity // Reflexo da tabela no banco de dados
@Table(name = "tb_stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto incremento
    @Column(name = "id") // Relacionando o id do backend com o id da tabela
    private Long id; // id so do backend

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "variation")
    private Double variation;
    
    
    @JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy") // Formato brasileiro
    @Column(name = "date")
    private LocalDate date;

    public Stock() {

    }

    public Stock(Long id, String name, Double price,Double variation, LocalDate date){
        this.id = id;
        this.name = name;
        this.price = price;
        this.variation = variation;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Double getVariation() {
        return variation;
    }

    public Double getPrice() {
        return price;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }

}
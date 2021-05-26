package com.project.bootcamp.modelDTO;

import java.time.LocalDate;

public class StockDTO {

    private Long id;
    private String name;
    private Double price;
    private LocalDate date;
    private Double variation;

    public StockDTO() {

    }

    public StockDTO(Long id, String name, Double price, LocalDate date, Double variation) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.variation = variation;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getVariation() {
        return variation;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }
}

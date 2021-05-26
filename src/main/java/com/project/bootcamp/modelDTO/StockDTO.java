package com.project.bootcamp.modelDTO;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class StockDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    @DecimalMin(value ="0.00")
    @Digits(integer = 6, fraction = 2)
    private Double price;
    // Ex: 100000.00

    @NotNull
    @JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy") // Formato brasileiro
    private LocalDate date;

    @NotNull
    @DecimalMin(value ="0.00")
    @Digits(integer = 3, fraction = 2)
    private Double variation;
    // Ex: 999.99%

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

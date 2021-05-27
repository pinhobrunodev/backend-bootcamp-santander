package com.project.bootcamp.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.project.bootcamp.model.Stock;
import com.project.bootcamp.modelDTO.StockDTO;

import org.springframework.stereotype.Component;

@Component // Indica para o Spring que precisa gerenciar tbm essa instancia
public class StockMapper {

    // Essa classe e necessario para transformar o DTO em uma Entitidade e usar no
    // Service

    /**
     * Recebemos um dto preenchido que veio da requisicao transformamos para entity
     * e retornamos ela
     */

    public Stock toEntity(StockDTO dto) {
        Stock stock = new Stock();
        stock.setId(dto.getId()); // id vem como null
        stock.setName(dto.getName());
        stock.setPrice(dto.getPrice());
        stock.setDate(dto.getDate());
        stock.setVariation(dto.getVariation());
        return stock;
    }

    /**
     * Recebemos uma entidade com o id preenchido
     * e vou voltar para o DTO agora com o ID preenchido
     */

    public StockDTO toDto(Stock stock) {
        StockDTO dto = new StockDTO();
        dto.setId(stock.getId()); // id ja preenchido
        dto.setName(stock.getName());
        dto.setPrice(stock.getPrice());
        dto.setDate(stock.getDate());
        dto.setVariation(stock.getVariation());
        return dto;
    }


    // Recebo uma lista de entidades e retorno uma lista de dtos
    public List<StockDTO> toDto(List<Stock> list) {
       // percorro a lista de entidades , pego item por item e mando pro toDto setando os valores da entidade no dto
       // e transformo em uma lista
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }
}

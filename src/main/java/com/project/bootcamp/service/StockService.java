package com.project.bootcamp.service;

import javax.validation.Valid;

import com.project.bootcamp.mapper.StockMapper;
import com.project.bootcamp.model.Stock;
import com.project.bootcamp.modelDTO.StockDTO;
import com.project.bootcamp.repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 // Regras de Negocio
@Service
public class StockService {
    
    @Autowired
    private StockMapper stockMapper;

    @Autowired(required=true)
    private StockRepository stockRepository;

    // Salvando
    // Transactional => Quando ocorre  algum Insert necessitamos utilizar para controlar essa transacao
    // EX: CAMADA 1 OK CAMADA 2 OK CAMADA 3 FALSE => ROLLBACK
    @Transactional 
    public StockDTO save(@Valid StockDTO dto) {
        Stock stock = stockMapper.toEntity(dto); // Vamos setar os valores do meu stock nos valores preenchidos do DTO
        stockRepository.save(stock); // Salvamos o stock que recebeu os valores dentro do DTO (Cria o ID) no banco de dados,que e o reflexo da da tb no bd
        return  stockMapper.toDto(stock); // Pegamos o dto e setamos com os valores do stock ja preenchidos(Principalmente para setar o ID no DTO)
    }

}

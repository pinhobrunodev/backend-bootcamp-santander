package com.project.bootcamp.service;

import java.util.Optional;

import javax.validation.Valid;

import com.project.bootcamp.exceptions.BusinessException;
import com.project.bootcamp.mapper.StockMapper;
import com.project.bootcamp.model.Stock;
import com.project.bootcamp.modelDTO.StockDTO;
import com.project.bootcamp.repository.StockRepository;
import com.project.bootcamp.util.MessageUtils;

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
        // Verificando se ja existe na base de dados uma magazine luiza cadastrada pra hoje
        // OBS : o nome do metodo preicsa ser exatamente igual aos atributos
        Optional<Stock> optional = stockRepository.findByNameAndDate(dto.getName(), dto.getDate());
        // Se o mesmo nome  e a mesma data juntos ja existirem no banco
        if(optional.isPresent()){
            // lancando a exception  e retornando um 422
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = stockMapper.toEntity(dto); // Vamos setar os valores do meu stock nos valores preenchidos do DTO
        stockRepository.save(stock); // Salvamos o stock que recebeu os valores dentro do DTO (Cria o ID) no banco de dados,que e o reflexo da da tb no bd
        return  stockMapper.toDto(stock); // Pegamos o dto e setamos com os valores do stock ja preenchidos(Principalmente para setar o ID no DTO)
    }

}

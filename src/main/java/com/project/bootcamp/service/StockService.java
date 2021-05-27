package com.project.bootcamp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.project.bootcamp.exceptions.BusinessException;
import com.project.bootcamp.exceptions.NotFoundException;
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

    @Transactional
    public StockDTO update(@Valid StockDTO dto) {
        // encontrar um stock para fazer o update
        // se o nome que eu informar e a data que informar ja exista e o id n seja eu
        Optional<Stock> optional = stockRepository.findByStockUpdate(dto.getName(),dto.getDate(), dto.getId());
        if(optional.isPresent()){
            // lancando a exception  e retornando um 422
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = stockMapper.toEntity(dto); // Vamos setar os valores do meu stock nos valores preenchidos do DTO
        stockRepository.save(stock); // Salvamos o stock que recebeu os valores dentro do DTO (Cria o ID) no banco de dados,que e o reflexo da da tb no bd
        return  stockMapper.toDto(stock); // Pegamos o dto e setamos com o
    }

    
    // Deletando pelo id
    @Transactional
    public StockDTO delete(Long id) {
        // VERIFICA SE EXISTE
        StockDTO dto = this.findById(id);
        // SE EXISTIR EU DELETO 
        stockRepository.deleteById(dto.getId());
        return dto;
    }

    // Transactional so pra leitura
    // Listando tudo
    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        // Estou convertendo para uma lista de DTO a lista de Entidade
        // pois o repository me retorna os dados no formato entity\
        // entao preciso fazer a conversao pro DTO , para que o controller funcione
       return stockMapper.toDto(stockRepository.findAll()); 
    }


    // Procurando pelo id
    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        /*Recebo um id , retorno o objeto em formato entity , uso o map para pegar item por item 
         da entidade e  setar os valores desses itens nos atributos de dto e RETORNAR o mesmo (DTO(PREENCHO O DTO))*/
      // se tiver alguma exception vou instanciar a exception que ja tem a msg mockada e lanco ela
       return stockRepository.findById(id).map(stockMapper::toDto).orElseThrow(NotFoundException::new);
    }

    // Procurando o stock pela data de hoje
    @Transactional(readOnly = true)
    public List<StockDTO> findByToday() {
        return stockRepository.findByToday(LocalDate.now()).map(stockMapper::toDto).orElseThrow(NotFoundException::new);
    }






}

package com.project.bootcamp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.project.bootcamp.modelDTO.StockDTO;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
    
    
    // Endpoint to  save (@POST)
    // Vai receber no corpo de um pedido um objeto do tipo StockDTO para salvar no banco 
     // como que eu quero q envie esse dado para mim ? formato Json  e como vou devolver? no formato Json
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO>save(@Valid @RequestBody StockDTO dto){
        // Retornando o DTO
        return ResponseEntity.ok(dto);
    }

    // Alterando
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
       return ResponseEntity.ok(dto);
    }

    // Listando os dados
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
        List<StockDTO> list = new ArrayList<>();
        StockDTO dto  = new StockDTO();
        dto.setId(1l);
        dto.setName("Magazine Luiza");
        dto.setPrice(100.00);
        dto.setVariation(0.1);
        dto.setDate(LocalDate.now());
        list.add(dto);
        return ResponseEntity.ok(list);
    }

    // Procurando item pelo id
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
        List<StockDTO> list = new ArrayList<>();
        StockDTO stock1  = new StockDTO();
        StockDTO stock2  = new StockDTO();
        stock1.setId(1l);
        stock1.setName("Magazine Luiza");
        stock1.setPrice(100.00);
        stock1.setVariation(0.1);
        stock1.setDate(LocalDate.now());
        list.add(stock1);
        stock2.setId(2l);
        stock2.setName("Ponto Frio");
        stock2.setPrice(200.00);
        stock2.setVariation(0.5);
        stock2.setDate(LocalDate.now());
        list.add(stock2);
        list.add(stock2);
        // Se o id informado for igual ao id dentro da lista (== 0) eu retorno ele
        StockDTO dtoSelected = list.stream().filter(x->x.getId().compareTo(id) ==  0).findFirst().get();
        return ResponseEntity.ok(dtoSelected);
    }

}

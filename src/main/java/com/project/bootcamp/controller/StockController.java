package com.project.bootcamp.controller;

import java.util.List;

import javax.validation.Valid;

import com.project.bootcamp.modelDTO.StockDTO;
import com.project.bootcamp.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// So conhece o DTO  e recebe o Service
@CrossOrigin // => Importante pro frontend na horar de chamar os endpoint
@RestController
@RequestMapping(value = "/stock")
public class StockController {
    
    @Autowired // Injecao de dependencia
    private StockService stockService;
    
    // Endpoint to  save (@POST)
    // Vai receber no corpo de um pedido um objeto do tipo StockDTO para salvar no banco 
     // como que eu quero q envie esse dado para mim ? formato Json  e como vou devolver? no formato Json
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO>save(@Valid @RequestBody StockDTO dto){
        // Retornando o DTO
        return ResponseEntity.ok(stockService.save(dto));
    }

    // Alterando
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
       return ResponseEntity.ok(stockService.update(dto));
    }

    // Deletando os dados
    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(stockService.delete(id));
    } 


    // Listando os dados
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
      return ResponseEntity.ok(stockService.findAll());
    }

    // Procurando item pelo id
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(stockService.findById(id));
    }

    // ENDPOINT : /bootcamp/stock/today
    // Procurando o stock pela data de hoje
    @GetMapping(value = "/today",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday(){
        return ResponseEntity.ok(stockService.findByToday());
    }


    
}

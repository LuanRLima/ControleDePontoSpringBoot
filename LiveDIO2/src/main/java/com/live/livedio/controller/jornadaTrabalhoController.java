package com.live.livedio.controller;

import com.live.livedio.model.JornadaTrabalho;
import com.live.livedio.repository.JornadaTrabalhoRepository;
import com.live.livedio.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class jornadaTrabalhoController {

    @Autowired
    JornadaTrabalhoRepository jornadaTrabalhoRepository;
    JornadaTrabalho jornadaTrabalho =  new JornadaTrabalho() ;


    @GetMapping
    public List<?> findAllJornadaTrabalho(){
        return jornadaTrabalhoRepository.findAll();
    }

    @GetMapping(value="{id}")
    public ResponseEntity<?> findByIdJornadaTrabalho(@PathVariable Long id){
        return jornadaTrabalhoRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public JornadaTrabalho createJornadaTrabalho(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaTrabalhoRepository.save(jornadaTrabalho);
    }
    @PutMapping(value="{id}")
    public ResponseEntity<?> updateJornadaTrabalho(@PathVariable Long id, @RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaTrabalhoRepository.findById(id).map(record -> {
            record.setDescricao(jornadaTrabalho.getDescricao());
            JornadaTrabalho update = jornadaTrabalhoRepository.save(record);
            return ResponseEntity.ok().body(update);
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deletejornadaTrabalho(@PathVariable Long id){
        return jornadaTrabalhoRepository.findById(id).map(record ->{
            jornadaTrabalhoRepository.deleteById(id);
            return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}

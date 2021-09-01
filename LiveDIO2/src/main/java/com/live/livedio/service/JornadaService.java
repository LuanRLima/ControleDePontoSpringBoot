package com.live.livedio.service;

import com.live.livedio.model.JornadaTrabalho;
import com.live.livedio.repository.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class JornadaService{

    @Autowired
    JornadaTrabalhoRepository jornadaTrabalhoRepository;

    public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho){
         return jornadaTrabalhoRepository.save(jornadaTrabalho);

    }



}

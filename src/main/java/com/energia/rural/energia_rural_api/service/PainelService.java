package com.energia.rural.energia_rural_api.service;

import com.energia.rural.energia_rural_api.model.Painel;
import com.energia.rural.energia_rural_api.repository.PainelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PainelService {

    @Autowired
    private PainelRepository painelRepository;

    public List<Painel> listarPaineis() {
        return painelRepository.findAll();
    }

    public Painel criarPainel(Painel painel) {
        return painelRepository.save(painel);
    }
}
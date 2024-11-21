package com.energia.rural.energia_rural_api.service;

import com.energia.rural.energia_rural_api.model.Localizacao;
import com.energia.rural.energia_rural_api.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public List<Localizacao> listarLocalizacoes() {
        return localizacaoRepository.findAll();
    }

    public Localizacao criarLocalizacao(Localizacao localizacao) {
        return localizacaoRepository.save(localizacao);
    }
}

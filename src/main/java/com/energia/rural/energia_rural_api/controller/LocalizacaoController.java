package com.energia.rural.energia_rural_api.controller;

import com.energia.rural.energia_rural_api.model.Localizacao;
import com.energia.rural.energia_rural_api.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @GetMapping
    public List<Localizacao> listarLocalizacoes() {
        return localizacaoService.listarLocalizacoes();
    }

    @PostMapping
    public ResponseEntity<Localizacao> criarLocalizacao(@RequestBody Localizacao localizacao) {
        Localizacao novaLocalizacao = localizacaoService.criarLocalizacao(localizacao);
        return ResponseEntity.ok(novaLocalizacao);
    }
}

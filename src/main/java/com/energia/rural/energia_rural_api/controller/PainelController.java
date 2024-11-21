package com.energia.rural.energia_rural_api.controller;

import com.energia.rural.energia_rural_api.model.Painel;
import com.energia.rural.energia_rural_api.service.PainelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paineis")
public class PainelController {

    @Autowired
    private PainelService painelService;

    @GetMapping
    public List<Painel> listarPaineis() {
        return painelService.listarPaineis();
    }

    @PostMapping
    public ResponseEntity<Painel> criarPainel(@RequestBody Painel painel) {
        Painel novoPainel = painelService.criarPainel(painel);
        return ResponseEntity.ok(novoPainel);
    }
}
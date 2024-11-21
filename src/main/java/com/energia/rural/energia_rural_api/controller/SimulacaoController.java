package com.energia.rural.energia_rural_api.controller;

import com.energia.rural.energia_rural_api.dto.SimulacaoRequest;
import com.energia.rural.energia_rural_api.dto.SimulacaoResponse;
import com.energia.rural.energia_rural_api.service.SimulacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simulacoes")
public class SimulacaoController {

    @Autowired
    private SimulacaoService simulacaoService;

    @PostMapping
    public ResponseEntity<SimulacaoResponse> criarSimulacao(@RequestBody SimulacaoRequest request) {
        SimulacaoResponse response = simulacaoService.criarSimulacao(request);
        return ResponseEntity.ok(response);
    }
}

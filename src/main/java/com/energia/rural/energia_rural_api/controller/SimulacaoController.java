package com.energia.rural.energia_rural_api.controller;

import com.energia.rural.energia_rural_api.dto.SimulacaoRequest;
import com.energia.rural.energia_rural_api.dto.SimulacaoResponse;
import com.energia.rural.energia_rural_api.service.SimulacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/simulacoes")
public class SimulacaoController {

    @Autowired
    private SimulacaoService simulacaoService;

    @PostMapping
    public ResponseEntity<EntityModel<SimulacaoResponse>> criarSimulacao(@RequestBody SimulacaoRequest request) {
        SimulacaoResponse response = simulacaoService.criarSimulacao(request);
        EntityModel<SimulacaoResponse> simulacaoModel = EntityModel.of(response,
                linkTo(methodOn(SimulacaoController.class).criarSimulacao(request)).withSelfRel());
        return ResponseEntity.ok(simulacaoModel);
    }
}
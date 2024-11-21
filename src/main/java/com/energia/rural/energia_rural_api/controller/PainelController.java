package com.energia.rural.energia_rural_api.controller;

import com.energia.rural.energia_rural_api.model.Painel;
import com.energia.rural.energia_rural_api.service.PainelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/paineis")
public class PainelController {

    @Autowired
    private PainelService painelService;

    @GetMapping
    public CollectionModel<EntityModel<Painel>> listarPaineis() {
        List<EntityModel<Painel>> paineis = painelService.listarPaineis().stream()
                .map(painel -> EntityModel.of(painel,
                        linkTo(methodOn(PainelController.class).listarPaineis()).withRel("paineis")))
                .collect(Collectors.toList());
        return CollectionModel.of(paineis, linkTo(methodOn(PainelController.class).listarPaineis()).withSelfRel());
    }

    @PostMapping
    public ResponseEntity<EntityModel<Painel>> criarPainel(@RequestBody Painel painel) {
        Painel novoPainel = painelService.criarPainel(painel);
        EntityModel<Painel> painelModel = EntityModel.of(novoPainel,
                linkTo(methodOn(PainelController.class).listarPaineis()).withRel("paineis"));
        return ResponseEntity.ok(painelModel);
    }
}
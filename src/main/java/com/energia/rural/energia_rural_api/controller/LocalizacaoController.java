package com.energia.rural.energia_rural_api.controller;

import com.energia.rural.energia_rural_api.model.Localizacao;
import com.energia.rural.energia_rural_api.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @GetMapping
    public CollectionModel<EntityModel<Localizacao>> listarLocalizacoes() {
        List<EntityModel<Localizacao>> localizacoes = localizacaoService.listarLocalizacoes().stream()
                .map(localizacao -> EntityModel.of(localizacao,
                        linkTo(methodOn(LocalizacaoController.class).listarLocalizacoes()).withRel("localizacoes")))
                .collect(Collectors.toList());
        return CollectionModel.of(localizacoes, linkTo(methodOn(LocalizacaoController.class).listarLocalizacoes()).withSelfRel());
    }

    @PostMapping
    public ResponseEntity<EntityModel<Localizacao>> criarLocalizacao(@RequestBody Localizacao localizacao) {
        Localizacao novaLocalizacao = localizacaoService.criarLocalizacao(localizacao);
        EntityModel<Localizacao> localizacaoModel = EntityModel.of(novaLocalizacao,
                linkTo(methodOn(LocalizacaoController.class).listarLocalizacoes()).withRel("localizacoes"));
        return ResponseEntity.ok(localizacaoModel);
    }
}
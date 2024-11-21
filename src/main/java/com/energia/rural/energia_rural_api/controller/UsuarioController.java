package com.energia.rural.energia_rural_api.controller;

import com.energia.rural.energia_rural_api.model.Usuario;
import com.energia.rural.energia_rural_api.service.UsuarioService;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public CollectionModel<EntityModel<Usuario>> listarUsuarios() {
        List<EntityModel<Usuario>> usuarios = usuarioService.listarUsuarios().stream()
                .map(usuario -> EntityModel.of(usuario,
                        linkTo(methodOn(UsuarioController.class).buscarUsuarioPorId(usuario.getUsuarioId())).withSelfRel(),
                        linkTo(methodOn(UsuarioController.class).listarUsuarios()).withRel("usuarios")))
                .collect(Collectors.toList());
        return CollectionModel.of(usuarios, linkTo(methodOn(UsuarioController.class).listarUsuarios()).withSelfRel());
    }

    @PostMapping
    public ResponseEntity<EntityModel<Usuario>> criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.criarUsuario(usuario);
        EntityModel<Usuario> usuarioModel = EntityModel.of(novoUsuario,
                linkTo(methodOn(UsuarioController.class).buscarUsuarioPorId(novoUsuario.getUsuarioId())).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).listarUsuarios()).withRel("usuarios"));
        return ResponseEntity.ok(usuarioModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Usuario>> buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuarioPorId(id)
                .map(usuario -> EntityModel.of(usuario,
                        linkTo(methodOn(UsuarioController.class).buscarUsuarioPorId(id)).withSelfRel(),
                        linkTo(methodOn(UsuarioController.class).listarUsuarios()).withRel("usuarios")))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
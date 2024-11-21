package com.energia.rural.energia_rural_api.service;

import com.energia.rural.energia_rural_api.dto.SimulacaoRequest;
import com.energia.rural.energia_rural_api.dto.SimulacaoResponse;
import com.energia.rural.energia_rural_api.model.*;
import com.energia.rural.energia_rural_api.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
public class SimulacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @Autowired
    private PainelRepository painelRepository;

    @Autowired
    private SimulacaoRepository simulacaoRepository;

    public SimulacaoResponse criarSimulacao(SimulacaoRequest request) {
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Localizacao localizacao = localizacaoRepository.findById(request.getLocalizacaoId())
                .orElseThrow(() -> new RuntimeException("Localização não encontrada"));
        Painel painel = painelRepository.findById(request.getPainelId())
                .orElseThrow(() -> new RuntimeException("Painel não encontrado"));

        Simulacao simulacao = new Simulacao();
        simulacao.setUsuario(usuario);
        simulacao.setLocalizacao(localizacao);
        simulacao.setPainel(painel);
        simulacao.setConsumoEstimado(request.getConsumoEstimado());
        simulacao.setRetornoFinanceiro(calcularRetorno(request.getConsumoEstimado(), painel.getCusto()));
        simulacao.setDataSimulacao(LocalDateTime.now());

        simulacao = simulacaoRepository.save(simulacao);

        SimulacaoResponse response = new SimulacaoResponse();
        response.setId(simulacao.getId());
        response.setUsuarioNome(usuario.getNome());
        response.setRegiao(localizacao.getRegiao());
        response.setConsumoEstimado(simulacao.getConsumoEstimado());
        response.setRetornoFinanceiro(simulacao.getRetornoFinanceiro());
        response.setDataSimulacao(simulacao.getDataSimulacao());

        return response;
    }

    private Double calcularRetorno(Double consumo, Double custo) {
        return (consumo * 0.5) - custo;
    }
}
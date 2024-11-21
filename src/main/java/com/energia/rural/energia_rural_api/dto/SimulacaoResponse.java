package com.energia.rural.energia_rural_api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SimulacaoResponse {
    private Long id;
    private String usuarioNome;
    private String regiao;
    private Double consumoEstimado;
    private Double retornoFinanceiro;
    private LocalDateTime dataSimulacao;
}

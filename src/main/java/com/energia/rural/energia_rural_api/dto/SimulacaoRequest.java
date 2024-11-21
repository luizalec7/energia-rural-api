package com.energia.rural.energia_rural_api.dto;

import lombok.Data;

@Data
public class SimulacaoRequest {
    private Long usuarioId;
    private Long localizacaoId;
    private Long painelId;
    private Double consumoEstimado;
}
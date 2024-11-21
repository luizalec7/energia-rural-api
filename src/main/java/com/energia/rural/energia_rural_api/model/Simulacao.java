package com.energia.rural.energia_rural_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "simulacao")
public class Simulacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SIMULACAO_ID", nullable = false)
    private Long simulacaoId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "localizacao_id", nullable = false)
    private Localizacao localizacao;

    @ManyToOne
    @JoinColumn(name = "painel_id", nullable = false)
    private Painel painel;

    @Column(name = "consumo_estimado", nullable = false)
    private Double consumoEstimado;

    @Column(name = "retorno_financeiro", nullable = false)
    private Double retornoFinanceiro;

    @Column(name = "data_simulacao", nullable = false)
    private LocalDateTime dataSimulacao;
}

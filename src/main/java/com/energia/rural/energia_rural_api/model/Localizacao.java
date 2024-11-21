package com.energia.rural.energia_rural_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "localizacao")
public class Localizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String regiao;

    @Column(name = "insolacao_media_horas", nullable = false)
    private Double insolacaoMediaHoras;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;
}

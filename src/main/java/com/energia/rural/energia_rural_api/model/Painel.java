package com.energia.rural.energia_rural_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "painel")
public class Painel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double potencia;

    @Column(nullable = false)
    private Double area;

    @Column(nullable = false)
    private Double custo;
}
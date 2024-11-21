package com.energia.rural.energia_rural_api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.energia.rural.energia_rural_api.model.Localizacao;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
}

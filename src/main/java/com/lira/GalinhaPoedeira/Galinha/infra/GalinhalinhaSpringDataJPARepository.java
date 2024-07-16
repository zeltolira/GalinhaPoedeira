package com.lira.GalinhaPoedeira.Galinha.infra;

import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GalinhalinhaSpringDataJPARepository extends JpaRepository <Galinha, UUID> {
    boolean existsByNomeGalinha(String nomeGalinha);
}

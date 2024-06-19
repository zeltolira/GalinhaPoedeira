package com.lira.Galinha.poedeira.infra;

import com.lira.Galinha.poedeira.domain.Galinha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GalinhalinhaSpingDataJPARepository extends JpaRepository <Galinha, UUID> {
    boolean existsByNomeGalinha(String nomeGalinha);
}

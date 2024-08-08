package com.lira.GalinhaPoedeira.Galinha.application.repository;

import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;

import java.util.List;
import java.util.UUID;

public interface GalinhaRepository {
    Galinha saveGalinha(Galinha galinha);
    Galinha getGalinhaById(UUID idGalinha);
    List<Galinha> getAllGalinhas();
    void deletaGalinha(Galinha galinha);
}

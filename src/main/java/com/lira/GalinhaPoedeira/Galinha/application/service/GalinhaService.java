package com.lira.GalinhaPoedeira.Galinha.application.service;

import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaPatchRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaDetalhadoResponse;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaListReponse;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaResponse;
import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import com.lira.GalinhaPoedeira.Galinha.domain.StatusGalinha;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface GalinhaService {
    GalinhaResponse postGalinha(GalinhaRequest galinhaRequest);
    GalinhaDetalhadoResponse getGalinhaById(UUID idGalinha);
    List<GalinhaListReponse> getAllGalinhas();
    void patchGalinhaById(UUID idGalinha, GalinhaPatchRequest galinhaPatchRequest);
    void deletaGalinha(UUID idGalinha);
    List<GalinhaDetalhadoResponse> consultaProducaoDiariaPorGalinha(LocalDate data);
    void mudaStatusParaInativa(UUID idGalinha);
    void mudaStatusParaAtiva(UUID idGalinha);
}

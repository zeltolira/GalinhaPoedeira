package com.lira.GalinhaPoedeira.Galinha.application.service;

import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaDetalhadoResponse;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaResponse;

import java.util.UUID;

public interface GalinhaService {
    GalinhaResponse postGalinha(GalinhaRequest galinhaRequest);
    GalinhaDetalhadoResponse getGalinhaById(UUID idGalinha);
}

package com.lira.GalinhaPoedeira.Galinha.application.service;

import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaDetalhadoResponse;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaResponse;
import com.lira.GalinhaPoedeira.Galinha.application.repository.GalinhaRepository;
import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class GalinhaApplicationService implements GalinhaService {
    private final GalinhaRepository galinhaRepository;

    @Override
    public GalinhaResponse postGalinha(GalinhaRequest galinhaRequest) {
        log.info("[inicia] GalinhaApplicationService - postGalinha");
        Galinha galinha = galinhaRepository.saveGalinha(new Galinha(galinhaRequest));
        log.info("[finaliza] GalinhaApplicationService - postGalinha");
        return new GalinhaResponse(galinha);
    }

    @Override
    public GalinhaDetalhadoResponse getGalinhaById(UUID idGalinha) {
        log.info("[inicia] GalinhaApplicationService - getGalinhaById");
        Galinha galinha = galinhaRepository.getGalinhaiById(idGalinha);
        log.info("[finaliza] GalinhaApplicationService - getGalinhaById");
        return new GalinhaDetalhadoResponse(galinha);
    }
}

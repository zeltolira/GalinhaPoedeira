package com.lira.GalinhaPoedeira.Galinha.application.service;

import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaPatchRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaDetalhadoResponse;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaListReponse;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaResponse;
import com.lira.GalinhaPoedeira.Galinha.application.repository.GalinhaRepository;
import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return new GalinhaResponse(galinha, "Galinha cadastrada com Sucesso!!!");
    }

    @Override
    public GalinhaDetalhadoResponse getGalinhaById(UUID idGalinha) {
        log.info("[inicia] GalinhaApplicationService - getGalinhaById");
        Galinha galinha = galinhaRepository.getGalinhaiById(idGalinha);
        log.info("[finaliza] GalinhaApplicationService - getGalinhaById");
        return new GalinhaDetalhadoResponse(galinha);
    }

    @Override
    public List<GalinhaListReponse> getAllGalinhas() {
        log.info("[inicia] GalinhaApplicationService - getAllGalinhas");
        List<Galinha> galinhas = galinhaRepository.getAllGalinhas();
        log.info("[finaliza] GalinhaApplicationService - getAllGalinhas");
        return GalinhaListReponse.converte(galinhas);
    }

    @Override
    public void patchGalinhaById(UUID idGalinha, GalinhaPatchRequest galinhaPatchRequest) {
        log.info("[inicia] GalinhaApplicationService - patchGalinhaById");
        Galinha galinha = galinhaRepository.getGalinhaiById(idGalinha);
        galinha.patchGalinha(galinhaPatchRequest);
        galinhaRepository.saveGalinha(galinha);
        log.info("[finaliza] GalinhaApplicationService - patchGalinhaById");

    }

    @Override
    public void deletaGalinha(UUID idGalinha) {
        log.info("[inicia] GalinhaApplicationService - deletaGalinha");
        Galinha galinha = galinhaRepository.getGalinhaiById(idGalinha);
        galinhaRepository.deletaGalinha(galinha);
        log.info("[finaliza] GalinhaApplicationService - deletaGalinha");

    }
}

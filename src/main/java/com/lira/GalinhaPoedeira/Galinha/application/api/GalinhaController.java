package com.lira.GalinhaPoedeira.Galinha.application.api;

import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaPatchRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaDetalhadoResponse;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaListReponse;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaResponse;
import com.lira.GalinhaPoedeira.Galinha.application.service.GalinhaService;
import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import com.lira.GalinhaPoedeira.Galinha.domain.StatusGalinha;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class GalinhaController implements GalinhaApi {
    private final GalinhaService galinhaService;

    @Override
    public GalinhaResponse postGalinha(GalinhaRequest galinhaRequest) {
        log.info("[inicia] GalinhaController - postGalinha");
        GalinhaResponse galinhaCriada = galinhaService.postGalinha(galinhaRequest);
        log.info("[finish] GalinhaController - postGalinha");
        return galinhaCriada;
    }

    @Override
    public GalinhaDetalhadoResponse getGalinhaById(UUID idGalinha) {
        log.info("[inicia] GalinhaController - getGalinhaById");
        GalinhaDetalhadoResponse galinhaDetalhada = galinhaService.getGalinhaById(idGalinha);
        log.info("[finish] GalinhaController - getGalinhaById");
        return galinhaDetalhada;
    }

    @Override
    public List<GalinhaListReponse> getAllGalinhas() {
        log.info("[inicia] GalinhaController - getAllGalinhas");
        List<GalinhaListReponse> galinhas = galinhaService.getAllGalinhas();
        log.info("[finaliza] GalinhaController - getAllGalinhas");
        return galinhas;
    }

    @Override
    public void patchGalinhaById(UUID idGalinha, GalinhaPatchRequest galinhaPatchRequest) {
        log.info("[inicia] GalinhaController - patchGalinhaById");
        log.info("[idGalinnha] {}", idGalinha);
        galinhaService.patchGalinhaById(idGalinha, galinhaPatchRequest);
        log.info("[finaliza] GalinhaController - patchGalinhaById");

    }

    @Override
    public void deleteGalinhaById(UUID idGalinha) {
        log.info("[inicia] GalinhaController - deleteGalinhaById");
        log.info("[idGalinnha] {}", idGalinha);
        galinhaService.deletaGalinha(idGalinha);
        log.info("[finaliza] GalinhaController - deleteGalinhaById");
    }

    @Override
    public List<GalinhaDetalhadoResponse> consultaProducaoDiariaPorGalinha(LocalDate data) {
        log.info("[inicia] GalinhaController - consultaProducaoDiariaPorGalinha");
        List<GalinhaDetalhadoResponse> galinhaDetalhadoResponse = galinhaService.consultaProducaoDiariaPorGalinha(data);
        log.info("[finaliza] GalinhaController - consultaProducaoDiariaPorGalinha");
        return galinhaDetalhadoResponse;
    }

    @Override
    public void mudaStatusParaInativa(UUID idGalinha) {
        log.info("[inicia] GalinhaController - mudaStatusParaInativa");
        galinhaService.mudaStatusParaInativa(idGalinha);
        log.info("[finaliza] GalinhaController - mudaStatusParaInativa");
    }

    @Override
    public void mudaStatusParaAtiva(UUID idGalinha) {
        log.info("[inicia] GalinhaController - mudaStatusParaAtiva");
        galinhaService.mudaStatusParaAtiva(idGalinha);
        log.info("[finaliza] GalinhaController - mudaStatusParaAtiva");

    }

}

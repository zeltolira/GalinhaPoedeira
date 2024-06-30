package com.lira.GalinhaPoedeira.Galinha.application.api;

import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaDetalhadoResponse;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaResponse;
import com.lira.GalinhaPoedeira.Galinha.application.service.GalinhaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
        log.info("[inicia] GalinhaController - postGalinha");
        GalinhaDetalhadoResponse galinhaDetalhada = galinhaService.getGalinhaById(idGalinha);
        log.info("[finish] GalinhaController - postGalinha");
        return galinhaDetalhada;
    }
}

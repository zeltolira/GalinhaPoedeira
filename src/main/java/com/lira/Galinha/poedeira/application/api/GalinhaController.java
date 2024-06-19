package com.lira.Galinha.poedeira.application.api;

import com.lira.Galinha.poedeira.application.api.request.GalinhaRequest;
import com.lira.Galinha.poedeira.application.api.response.GalinhaResponse;
import com.lira.Galinha.poedeira.application.service.GalinhaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}

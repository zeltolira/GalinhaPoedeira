package com.lira.Galinha.poedeira.application.service;

import com.lira.Galinha.poedeira.application.api.request.GalinhaRequest;
import com.lira.Galinha.poedeira.application.api.response.GalinhaResponse;
import com.lira.Galinha.poedeira.application.repository.GalinhaRepository;
import com.lira.Galinha.poedeira.domain.Galinha;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}

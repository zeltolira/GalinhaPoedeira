package com.lira.GalinhaPoedeira.RegistroOvos.application.service;

import com.lira.GalinhaPoedeira.Galinha.application.repository.GalinhaRepository;
import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.request.RegistroOvosRequest;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.RegistroOvosResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.repository.RegistroOvosRepository;
import com.lira.GalinhaPoedeira.RegistroOvos.domain.RegistroOvos;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class RegistroOvosApplicationService implements RegistroOvosService {
    private final GalinhaRepository galinhaRepository;
    private final RegistroOvosRepository registroOvosRepository;

    @Override
    public RegistroOvosResponse registrarOvos(UUID idGalinha, RegistroOvosRequest registroOvosRequest) {
        log.info("[inicia] RegistroOvosServiceImpl - registrarOvos");
        Galinha galinha = galinhaRepository.getGalinhaiById(idGalinha);
        RegistroOvos registroOvos = registroOvosRepository.salvaOvos(new RegistroOvos(galinha, registroOvosRequest));
        log.info("[finaliza] RegistroOvosServiceImpl - registrarOvos");
        return new RegistroOvosResponse(registroOvos);
    }
}

package com.lira.GalinhaPoedeira.RegistroOvos.application.service;

import com.lira.GalinhaPoedeira.Galinha.application.repository.GalinhaRepository;
import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.request.RegistroOvosRequest;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoMensalResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoPorDataResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.RegistroOvosResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.repository.RegistroOvosRepository;
import com.lira.GalinhaPoedeira.RegistroOvos.domain.RegistroOvos;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class RegistroOvosApplicationService implements RegistroOvosService {
    private final GalinhaRepository galinhaRepository;
    private final RegistroOvosRepository registroOvosRepository;

    @Override
    public RegistroOvosResponse registrarOvos(UUID idGalinha, RegistroOvosRequest registroOvosRequest) {
        log.info("[inicia] RegistroOvosApplicationService - registrarOvos");
        Galinha galinha = galinhaRepository.getGalinhaiById(idGalinha);
        RegistroOvos registroOvos = registroOvosRepository.salvaOvos(new RegistroOvos(galinha, registroOvosRequest));
        log.info("[finaliza] RegistroOvosApplicationService - registrarOvos");
        return new RegistroOvosResponse(registroOvos);
    }
    @Override
    public List<ProducaoPorDataResponse> consultaProducaoPorData(LocalDate data) {
        log.info("[inicia] RegistroOvosApplicationService - consultaProducaoPorData");
        List<ProducaoPorDataResponse> producao = registroOvosRepository.consultaProducaoPorData(data);
        log.info("[finaliza] RegistroOvosApplicationService - consultaProducaoPorData");
        return producao;
    }

    @Override
    public List<ProducaoMensalResponse> consultaProducaoMensal(YearMonth data) {
        log.info("[inicia] RegistroOvosApplicationService - consultaProducaoMensal");
        ProducaoMensalResponse producao = registroOvosRepository.consultaProducaoMensal(data.atDay(1));
        log.info("[finaliza] RegistroOvosApplicationService - consultaProducaoMensal");
        return List.of(producao);
    }
}


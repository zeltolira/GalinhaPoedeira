package com.lira.GalinhaPoedeira.RegistroOvos.application.api;

import com.lira.GalinhaPoedeira.RegistroOvos.application.api.request.RegistroOvosRequest;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoPorDataResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.RegistroOvosResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.service.RegistroOvosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class RegistroOvoController implements RegistraOvosApi {
    private final RegistroOvosService registroOvosService;

    @Override
    public RegistroOvosResponse resgistraOvos(UUID idGalinha, RegistroOvosRequest registroOvosRequest) {
        log.info("[inicia] RegistroOvosController - registrarOvos");
        RegistroOvosResponse ovoRegistrado = registroOvosService.registrarOvos(idGalinha, registroOvosRequest);
        log.info("[finaliza] RegistroOvosController - registrarOvos");
        return ovoRegistrado;
    }

    @Override
    public List<ProducaoPorDataResponse> consultaProducaoPorData(LocalDate data) {
        log.info("[inicia] RegistroOvosController - consultaProducaoPorData");
        List<ProducaoPorDataResponse> producaoGalinha = registroOvosService.consultaProducaoPorData(data);
        log.info("[finaliza] RegistroOvosController - consultaProducaoPorData");
        return producaoGalinha;
    }
}
